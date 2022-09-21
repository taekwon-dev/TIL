package com.til.algorithm.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 이진 검색 트리
 * <p>
 * 주어진 트리를 오름차순으로 정렬 후 해당 배열을 통해 BST를 만드려고 시도 -> 반드시 문제 조건에 주어진 트리와 같다고 보장할 수 없음 !
 */
public class BOJ_5639 {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }

        public void insert(int key) {
            if (key < this.val) {
                if (this.left == null) {
                    this.left = new Node(key);
                } else {
                    this.left.insert(key);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(key);
                } else {
                    this.right.insert(key);
                }
            }
        }

        public Node insert(Node root, int key) {
            if (root == null) {
                root = new Node(key);
                return root;
            }
            if (key < root.val) {
                root.left = insert(root.left, key);
            } else if (key > root.val) {
                root.right = insert(root.right, key);
            }
            return root;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String str = br.readLine();
            if (str == null || str.equals("")) {
                break;
            }
            root.insert(root, Integer.parseInt(str));
        }
        postorder(root);
    }

    private static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.val);
        }
    }

}
