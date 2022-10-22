package com.til.algorithm.leetCode.tree;


public class LEET_965_b {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        return dfs(root.left, val) && dfs(root.right, val);
    }
}
