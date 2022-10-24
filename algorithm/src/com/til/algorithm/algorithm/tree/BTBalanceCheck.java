package com.til.algorithm.algorithm.tree;

public class BTBalanceCheck {
    static class Tree {
        static class Node {
            int data;
            Node left, right;

            public Node(int data) {
                this.data = data;
            }
        }

        Node root;

        Tree(int size) {
            root = makeBST(0, size - 1);
        }

        private Node makeBST(int start, int end) {
            if (start > end) return null;
            int mid = (start + end) / 2;
            Node node = new Node(mid);
            node.left = makeBST(start, mid - 1);
            node.right = makeBST(mid + 1, end);
            return node;
        }

        private boolean isBalanced(Node root) {
            if (root == null) return true;
            int heightDiff = getHeight(root.left) - getHeight(root.right);
            if (heightDiff > 1) {
                return false;
            } else {
                return isBalanced(root.left) && isBalanced(root.right);
            }
        }

        private int getHeight(Node root) {
            if (root == null) return -1;
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }

    /*

[balanced]
               (4)
              /  \
             /    \
            /      \
          (1)      (7)
         /   \     /  \
       (0)   (2)  (5)  (8)
                    \    \
                    (6)  (9)

[~ balanced]
              (4)
              /  \
             /    \
            /      \
          (1)      (7)
         /   \     /  \
       (0)   (2)  (5)  (8)
                    \    \
                    (6)  (9)
                           \
                           (10)
     */
    public static void main(String[] args) {
        Tree t = new Tree(10);
        System.out.println(t.isBalanced(t.root));
    }
}
