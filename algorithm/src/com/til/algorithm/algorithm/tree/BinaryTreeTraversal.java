package com.til.algorithm.algorithm.tree;

class Node {
    int data;
    Node left;
    Node right;
}

class Tree {
    public Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node makeNode(Node left, int data, Node right) {
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }

    // L -> Root -> R
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }
}

public class BinaryTreeTraversal {
    public static void main(String[] args) {
        Tree tree = new Tree();

        Node n10 = tree.makeNode(null, 10, null);
        Node n9 = tree.makeNode(null, 9, n10);

        Node n7 = tree.makeNode(null, 7, null);
        Node n6 = tree.makeNode(null, 6, n7);

        Node n8 = tree.makeNode(n6, 8, n9);


        Node n4 = tree.makeNode(null, 4, null);
        Node n3 = tree.makeNode(null, 3, n4);

        Node n1 = tree.makeNode(null, 1, null);

        Node n2 = tree.makeNode(n1, 2, n3);

        Node n5 = tree.makeNode(n2, 5, n8);

        tree.inorder(n5);
        System.out.println();
        tree.preorder(n5);
        System.out.println();
        tree.postorder(n5);

    }
}
