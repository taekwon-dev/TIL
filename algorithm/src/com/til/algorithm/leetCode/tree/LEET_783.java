package com.til.algorithm.leetCode.tree;

public class LEET_783 {

    private int min = Integer.MAX_VALUE;
    private TreeNode prev;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        inorder(root.right);
    }
}