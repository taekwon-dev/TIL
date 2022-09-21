package com.til.algorithm.leetCode.tree;

public class LEET_938 {
    private int rangeSum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root, low, high);
        return rangeSum;
    }

    private void inorder(TreeNode node, int low, int high) {
        if (node != null) {
            inorder(node.left, low, high);
            if (node.val >= low && node.val <= high) {
                rangeSum += node.val;
            }
            inorder(node.right, low, high);
        }
    }
}
