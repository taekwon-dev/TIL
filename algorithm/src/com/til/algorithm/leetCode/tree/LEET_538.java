package com.til.algorithm.leetCode.tree;

public class LEET_538 {
    int plus = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        root.right = convertBST(root.right);
        root.val += plus;
        plus = root.val;
        if (root.left == null) root.left = null;
        root.left = convertBST(root.left);
        return root;
    }
}
