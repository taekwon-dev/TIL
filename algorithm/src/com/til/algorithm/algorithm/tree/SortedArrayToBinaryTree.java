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
        root = makeTreeR(arr, 0, arr.length - 1);
    }

    public Node makeTreeR(int[] arr, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        node.left = makeTreeR(arr, start, mid - 1);
        node.right = makeTreeR(arr, mid + 1, end);
        return node;
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
    }
}
