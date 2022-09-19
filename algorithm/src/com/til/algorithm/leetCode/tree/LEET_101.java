package com.til.algorithm.leetCode.tree;

public class LEET_101 {
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root.left, root.right);
    }

    private boolean checkSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        if (l.val != r.val) return false;

        return checkSymmetric(l.left, r.right) && checkSymmetric(l.right, r.left);
    }
}
