package com.til.algorithm.leetCode.tree;

public class LEET_538 {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);

        return root;
    }
}