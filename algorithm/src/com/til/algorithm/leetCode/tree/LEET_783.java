package com.til.algorithm.leetCode.tree;

/**
 *  Minimum Distance Between BST Nodes
 */
public class LEET_783 {
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        if (root == null) return min;
        minDiffInBST(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        minDiffInBST(root.right);
        return min;
    }
}
