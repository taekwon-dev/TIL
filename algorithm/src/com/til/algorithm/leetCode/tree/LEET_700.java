package com.til.algorithm.leetCode.tree;

/**
 *  Search in a Binary Search Tree
 */
public class LEET_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return root;
        if (root.val == val) return root;

        if (root.val > val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}
