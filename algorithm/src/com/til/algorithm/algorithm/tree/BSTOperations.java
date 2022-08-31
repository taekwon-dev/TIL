package com.til.algorithm.algorithm.tree;

/**
 *  https://www.youtube.com/watch?v=xxADG17SveY
 */
class BinarySearchTreeForOps {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    Node root;

    public Node search(Node root, int key) {
        if (root == null || root.data == key) return root;
        if (root.data > key) return search(root.left, key);
        return search(root.right, key);
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    public Node delete(Node root, int data) {
        if (root == null) return root;
        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.data = findMin(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    int findMin(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    public void inorder() {
        inorder(root);
        System.out.println("");
    }

    // L Root R
    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}

public class BSTOperations {
    public static void main(String[] args) {
        BinarySearchTreeForOps bst = new BinarySearchTreeForOps();
        /*
                4
               / \
              /   \
             2     6
            / \   / \
           1   3 5   7
         */
        bst.insert(4);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(6);
        bst.insert(5);
        bst.insert(7);

        bst.inorder();
        bst.delete(6);
        bst.inorder();

    }
}
