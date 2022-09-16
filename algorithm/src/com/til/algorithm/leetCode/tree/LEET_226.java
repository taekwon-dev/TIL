package com.til.algorithm.leetCode.binary_tree;

import com.til.algorithm.leetCode.tree.TreeNode;

public class LEET_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        if (root.left == null && root.right == null) return root;
        if (root.left != null) invertTree(root.left);
        if (root.right != null) invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
