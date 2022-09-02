package com.til.algorithm.leetCode.tree;

/**
 *  Range Sum of BST
 *
 *  Given the root node of a binary search tree and two integers low and high,
 *  return the sum of values of all nodes with a value in the inclusive range [low, high].
 */
public class LEET_938 {
    private int rangeSum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root, low, high);
        return rangeSum;
    }

    private void inorder(TreeNode node, int low, int high) {
        if (node != null) {
            inorder(node.left, low, high);
            if (node.val >= low && node.val <= high) {
                rangeSum += node.val;
            }
            inorder(node.right, low, high);
        }
    }
}
