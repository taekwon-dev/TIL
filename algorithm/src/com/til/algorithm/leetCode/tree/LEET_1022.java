package com.til.algorithm.leetCode.tree;

public class LEET_1022 {
    public int sumRootToLeaf(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode root, int prev) {
        if (root == null) {
            return 0;
        }
        int curr = prev * 2 + root.val;
        if (root.left == null && root.right == null) {
            return curr;
        }
        return sum(root.left, curr) + sum(root.right, curr);
    }
}
