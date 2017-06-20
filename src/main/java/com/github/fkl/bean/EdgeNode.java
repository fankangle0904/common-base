package com.github.fkl.bean;

/**
 * Created by kanglefan on 17-6-20.
 */
public class EdgeNode {

    private int vexSubscript;
    EdgeNode next;

    public EdgeNode(int vexSubscript, EdgeNode next) {
        this.vexSubscript = vexSubscript;
        this.next = next;
    }

    public int getVexSubscript() {
        return vexSubscript;
    }

    public void setVexSubscript(int vexSubscript) {
        this.vexSubscript = vexSubscript;
    }

    public EdgeNode getNext() {
        return next;
    }

    public void setNext(EdgeNode next) {
        this.next = next;
    }
}
