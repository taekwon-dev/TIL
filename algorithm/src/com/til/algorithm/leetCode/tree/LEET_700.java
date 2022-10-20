package com.til.algorithm.leetCode.tree;

public class LEET_700 {
    public TreeNode searchBST(TreeNode root, int key) {
        if (root == null || root.val == key) {
            return root;
        }
        if (root.val > key) {
            return searchBST(root.left, key);
        }
        return searchBST(root.right, key);
    }
}
