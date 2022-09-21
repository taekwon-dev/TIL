package com.til.algorithm.leetCode.tree;

public class LEET_1038 {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            dfs(root);
        }
        return root;
    }

    private void dfs(TreeNode root) {
        if (root.right != null) {
            dfs(root.right);
        }
        int val = root.val;
        root.val = sum + val;
        sum = root.val;
        if (root.left != null) {
            dfs(root.left);
        }
    }
}
