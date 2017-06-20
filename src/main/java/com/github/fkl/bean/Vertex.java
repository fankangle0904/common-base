package com.github.fkl.bean;

/**
 * Created by kanglefan on 17-6-20.
 */
public class Vertex {

    private int vexInfo;

    private EdgeNode firstEdge;

    public Vertex(int vexInfo, EdgeNode firstEdge) {
        this.vexInfo = vexInfo;
        this.firstEdge = firstEdge;
    }

    public int getVexInfo() {
        return vexInfo;
    }

    public void setVexInfo(int vexInfo) {
        this.vexInfo = vexInfo;
    }

    public EdgeNode getFirstEdge() {
        return firstEdge;
    }

    public void setFirstEdge(EdgeNode firstEdge) {
        this.firstEdge = firstEdge;
    }
}
