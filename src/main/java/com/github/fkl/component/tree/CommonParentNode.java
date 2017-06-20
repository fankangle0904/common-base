package com.github.fkl.component.tree;

import com.github.fkl.bean.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by kanglefan on 17-6-19.
 */
public class CommonParentNode {

    public static void main(String[] args) {
        // Tree初始化
        Node node1 = new Node(4, null, null);
        Node node2 = new Node(5, null, null);
        Node node3 = new Node(3, null, null);
        Node node4 = new Node(2, node1, node2);
        Node node5 = new Node(1, node4, node3);
        // 方法一
        Node commonParent = getCommonParent(node5, node1, node2);
        System.out.println(commonParent.getVal());
        // 方法二
        ArrayList<Node> arrayList1 = getParent(node5, node2);
        ArrayList<Node> arrayList2 = getParent(node5, node1);
        Collections.reverse(arrayList2);
        for (Node node : arrayList2) {
            if (arrayList1.contains(node)) {
                System.out.println(node.getVal());
                break;
            }
        }
    }

    public static ArrayList<Node> getParent(Node root, Node find) {
        ArrayList<Node> arrayList1 = new ArrayList<Node>();
        ArrayList<Node> parentList1 = new ArrayList<Node>();
        getParent(root, find, arrayList1, parentList1);
        return parentList1;
    }

    private static void getParent(Node root, Node find, ArrayList<Node> arrayList, ArrayList<Node> parentList) {
        if (root != null) {
            arrayList.add(root);
            if (root == find) {
                parentList.addAll(arrayList);
            }
            getParent(root.getLeft(), find, arrayList, parentList);
            getParent(root.getRight(), find, arrayList, parentList);
            arrayList.remove(root);
        }
    }

    public static Node getCommonParent(Node root, Node find1, Node find2) {
        if (root == null || find1 == null || find2 == null) {
            return null;
        }
        Map<Node, Node> parentMap = new HashMap<Node, Node>();
        Queue<Node> queue = new ArrayDeque<Node>();
        parentMap.put(root, null);
        queue.add(root);
        while (!parentMap.containsKey(find1) || !parentMap.containsKey(find2)) {
            Node current = queue.poll();
            if (current.getLeft() != null) {
                parentMap.put(current.getLeft(), current);
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                parentMap.put(current.getRight(), current);
                queue.add(current.getRight());
            }
        }
        //
        Set<Node> find1Parent = new HashSet<Node>();
        Node pos = find1;
        while (pos != null) {
            find1Parent.add(pos);
            pos = parentMap.get(pos);
        }
        pos = find2;
        while (!find1Parent.contains(pos)) {
            pos = parentMap.get(pos);
        }
        return pos;
    }
}
