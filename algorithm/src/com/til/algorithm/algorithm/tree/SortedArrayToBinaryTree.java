package com.til.algorithm.algorithm.tree;

class Tree2 {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public void makeTree(int[] arr) {
        root = makeBST(arr, 0, arr.length - 1);
    }

    public Node makeBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = makeBST(arr, start, mid - 1);
        root.right = makeBST(arr, mid + 1, end);
        return root;
    }

    public void searchBTree(Node n, int find) {
        if (find < n.data) {
            System.out.println("Data is smaller than " + n.data);
            searchBTree(n.left, find);
        } else if (find > n.data) {
            System.out.println("Data is bigger than " + n.data);
            searchBTree(n.right, find);
        } else {
            System.out.println("Data Found");
        }
    }
    
    public Node searchNode(Node root, int key) {
        if (root == null || root.data == key) {
            return root;
        }
        if (root.data > key) {
            return searchNode(root.left, key);
        }
        return searchNode(root.right, key);
    }
}

public class SortedArrayToBinaryTree {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Tree2 t = new Tree2();
        t.makeTree(arr);
        t.searchBTree(t.root, 2);
        System.out.println("t = " + t.root);
        System.out.println("t.searchNode(t.root, 5).data = " + t.searchNode(t.root, 5).data);
    }
}
