package com.til.algorithm.leetCode.tree;

/**
 *  ⚠️
 *  Binary Search Tree to Greater Sum Tree
 *
 *  Given the root of a Binary Search Tree (BST),
 *  convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
 */
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
