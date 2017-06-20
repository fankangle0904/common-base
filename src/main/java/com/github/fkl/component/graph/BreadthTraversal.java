package com.github.fkl.component.graph;

import com.github.fkl.bean.EdgeNode;
import com.github.fkl.bean.Vertex;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by kanglefan on 17-6-20.
 */
public class BreadthTraversal {
    public static void main(String[] args) {
        Vertex vertex0 = new Vertex(0, null);
        Vertex vertex1 = new Vertex(1, null);
        Vertex vertex2 = new Vertex(2, null);
        Vertex vertex3 = new Vertex(3, null);
        Vertex vertex4 = new Vertex(4, null);
        Vertex vertex5 = new Vertex(5, null);
        Vertex[] vertexes = {vertex0, vertex1, vertex2, vertex3, vertex4, vertex5};
        vertexes[0].setFirstEdge(new EdgeNode(vertex1.getVexInfo(), new EdgeNode(vertex5.getVexInfo(), null)));
        vertexes[1].setFirstEdge(new EdgeNode(vertex0.getVexInfo(), new EdgeNode(vertex2.getVexInfo(), null)));
        vertexes[2].setFirstEdge(new EdgeNode(vertex3.getVexInfo(), null));
        vertexes[3].setFirstEdge(new EdgeNode(vertex0.getVexInfo(), new EdgeNode(vertex4.getVexInfo(), null)));
        //
        Queue<Integer> queue = new ArrayDeque<Integer>();
        boolean[] visited = new boolean[vertexes.length];

        for (Vertex vertex : vertexes) {
            if (!visited[vertex.getVexInfo()]) {
                System.out.println(vertex.getVexInfo());
                visited[vertex.getVexInfo()] = true;
            }
            queue.add(vertex.getVexInfo());

            while (!queue.isEmpty()) {
                int pos = queue.poll();
                EdgeNode edgeNode = vertexes[pos].getFirstEdge();
                while (edgeNode != null) {
                    if (!visited[edgeNode.getVexSubscript()]) {
                        System.out.println(edgeNode.getVexSubscript());
                        visited[edgeNode.getVexSubscript()] = true;
                        queue.add(edgeNode.getVexSubscript());
                    }
                    edgeNode = edgeNode.getNext();
                }
            }
        }
    }
}
