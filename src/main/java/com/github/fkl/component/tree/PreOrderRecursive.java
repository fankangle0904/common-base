package com.github.fkl.component.tree;

import com.github.fkl.bean.Node;

/**
 * Created by kanglefan on 17-6-19.
 */
public class PreOrderRecursive {
    public static void main(String[] args) {
        Node node1 = new Node(4, null, null);
        Node node2 = new Node(5, null, null);
        Node node3 = new Node(3, null, null);
        Node node4 = new Node(2, node1, node2);
        Node node5 = new Node(1, node4, node3);
        preOrderRecursive(node5);
    }

    private static void preOrderRecursive(Node root) {
        if (root != null) {
            System.out.println(root.getVal());
            preOrderRecursive(root.getLeft());
            preOrderRecursive(root.getRight());
        }
    }
}
