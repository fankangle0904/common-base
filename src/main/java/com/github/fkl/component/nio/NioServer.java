package com.github.fkl.component.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by kanglefan on 17-6-1.
 */
public class NioServer {
    /*缓冲区大小*/
    private  int BLOCK = 4096;
    /*接受数据缓冲区*/
    private  ByteBuffer sendbuffer = ByteBuffer.allocate(BLOCK);
    /*发送数据缓冲区*/
    private  ByteBuffer receivebuffer = ByteBuffer.allocate(BLOCK);

    private Selector selector;

    private void initServer(int port) throws Exception {
        // 初始化selector
        selector = Selector.open();

        // SelectorProvider.openServerSocketChannel(),绑定端口,设置IO mode为非阻塞
        ServerSocketChannel channel = (ServerSocketChannel) ServerSocketChannel.open().configureBlocking(false);

        ServerSocket serverSocket = channel.socket();
        serverSocket.bind(new InetSocketAddress(port));

        // 服务端先注册接收KEY
        SelectionKey selectionKey = channel.register(selector, SelectionKey.OP_ACCEPT);
    }

    private void listen() throws Exception {
        while (true) {
            int num = selector.select();
            if (num < 1) continue;
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> itr = selectedKeys.iterator();
            while (itr.hasNext()) {
                SelectionKey key = itr.next();
                itr.remove();
                handleKey(key);
            }
        }
    }

    private void handleKey(SelectionKey key) {
        try {
            if (key.isAcceptable()) {
                doAccept(key);
            } else if (key.isReadable()) {
                doRead(key);
            } else if (key.isWritable()) {
                doWrite(key);
            }
        } catch (Exception e) {

        }
    }

    private void doAccept(SelectionKey key) throws Exception {
        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = (SocketChannel) channel.accept().configureBlocking(false);
        SelectionKey newKey = socketChannel.register(selector, SelectionKey.OP_READ);
    }

    private void doRead(SelectionKey key) throws Exception {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        receivebuffer.clear();
        int byteLen = socketChannel.read(receivebuffer);
        if (byteLen > 0) {
            // 服务器接受客户端数据
            String receiveText = new String(receivebuffer.array(), 0, byteLen);
            System.out.println("服务器端接受客户端数据--:"+receiveText);
            socketChannel.register(selector, SelectionKey.OP_WRITE);
        }
    }

    private void doWrite(SelectionKey key) throws Exception {
        sendbuffer.clear();
        SocketChannel socketChannel = (SocketChannel) key.channel();
        String sendText = "来自服务器的消息";
        sendbuffer.put(sendText.getBytes());
        // 将缓冲区各标识位复位
        sendbuffer.flip();
        // 服务器向客户端发送数据
        socketChannel.write(sendbuffer);
        System.out.println("服务器端向客户端发送数据--："+sendText);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    public static void main(String[] args) throws Exception {
        NioServer nioServer = new NioServer();
        nioServer.initServer(8888);
        nioServer.listen();
    }
}
