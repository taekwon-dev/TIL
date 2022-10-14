package com.til.algorithm.leetCode.tree;

public class LEET_110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.abs(right - left) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
