package com.til.algorithm.leetCode.tree;

import com.til.algorithm.leetCode.tree.TreeNode;

public class LEET_104 {
    int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return max;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            max = Math.max(max, depth);
            return;
        }
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }

        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }
}
