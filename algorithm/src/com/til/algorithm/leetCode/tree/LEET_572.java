package com.til.algorithm.leetCode.tree;

public class LEET_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSame(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode r, TreeNode s) {
        if (r == null && s == null) return true;
        if (r == null || s == null) return false;
        if (r.val != s.val) return false;
        return isSame(r.left, s.left) && isSame(r.right, s.right);
    }
}
