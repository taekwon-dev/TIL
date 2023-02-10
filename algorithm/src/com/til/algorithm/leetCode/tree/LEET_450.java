package com.til.algorithm.leetCode.tree;

public class LEET_450 {

    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root.val > val) {
            root.left = deleteNode(root.left , val);
        } else if (root.val < val) {
            root.right = deleteNode(root.right, val);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else if (root.left != null && root.right != null) {
                root.val = findMin(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private int findMin(TreeNode root) {
        int min = root.val;
        while (root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return min;
    }
}