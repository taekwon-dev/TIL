package com.til.algorithm.leetCode.tree;

import com.til.algorithm.leetCode.tree.TreeNode;

public class LEET_112 {
    boolean answer = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        dfs(root, targetSum, root.val);
        return answer;
    }

    private void dfs(TreeNode root, int targetSum, int sum) {
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                answer = true;
            }
            return;
        }
        if (root.left != null) dfs(root.left, targetSum, sum + root.left.val);

        if (root.right != null) dfs(root.right, targetSum, sum + root.right.val);
    }
}
