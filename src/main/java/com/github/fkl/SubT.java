package com.github.fkl;

/**
 * Created by kanglefan on 17-6-7.
 */
public class SubT extends Thread {

    @Override
    public void run() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        SubT subT = new SubT();
        subT.start();
    }
}
