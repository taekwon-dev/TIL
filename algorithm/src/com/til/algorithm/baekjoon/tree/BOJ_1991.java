package com.til.algorithm.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 트리 순회
 * <p>
 * 이진 트리 키워드 확인
 */
public class BOJ_1991 {
    static class Node {
        char val;
        Node left;
        Node right;

        public Node(char val) {
            this.val = val;
        }
    }

    static class Tree {
        Node root;

        public void add(char val, char l_val, char r_val) {
            if (root == null) {
                root = new Node(val);
                if (l_val != '.') root.left = new Node(l_val);
                if (r_val != '.') root.right = new Node(r_val);
            } else {
                search_and_add(root, val, l_val, r_val);
            }
        }

        public void search_and_add(Node node, char val, char l_val, char r_val) {
            if (node == null) return;
            else if (node.val == val) {
                if (l_val != '.') node.left = new Node(l_val);
                if (r_val != '.') node.right = new Node(r_val);
            } else {
                search_and_add(node.left, val, l_val, r_val);
                search_and_add(node.right, val, l_val, r_val);
            }
        }

        public void preorder(Node node) {
            if (node != null) {
                System.out.print(node.val);
                preorder(node.left);
                preorder(node.right);
            }
        }

        public void inorder(Node node) {
            if (node != null) {
                inorder(node.left);
                System.out.print(node.val);
                inorder(node.right);
            }
        }

        public void postorder(Node node) {
            if (node != null) {
                postorder(node.left);
                postorder(node.right);
                System.out.print(node.val);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            char[] val = br.readLine().replaceAll(" ", "").toCharArray();
            tree.add(val[0], val[1], val[2]);
        }

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
    }
}
