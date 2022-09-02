package com.til.algorithm.leetCode.tree;

public class LEET_530 {
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            if (prev != null) {
                min = Math.min(min, node.val - prev.val);
            }
            prev = node;
            inorder(node.right);
        }
    }
}
