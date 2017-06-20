package com.github.fkl.component.graph;

import com.github.fkl.bean.EdgeNode;
import com.github.fkl.bean.Vertex;

/**
 * Created by kanglefan on 17-6-20.
 */
public class DepthTraversal {

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
        boolean[] flags = new boolean[6];
        dfs(vertexes, 0, flags);
    }

    private static void dfs(Vertex[] vertexes, int pos, boolean[] flags) {
        if (!flags[pos]) {
            System.out.println(pos);
            flags[pos] = true;
            EdgeNode edgeNode = vertexes[pos].getFirstEdge();
            while (edgeNode != null) {
                dfs(vertexes, edgeNode.getVexSubscript(), flags);
                edgeNode = edgeNode.getNext();
            }
        }
    }
}
