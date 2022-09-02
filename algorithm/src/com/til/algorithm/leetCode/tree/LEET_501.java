package com.til.algorithm.leetCode.tree;

/**
 *  Find Mode in Binary Search Tree
 *
 *  Mode : the most frequently occurred element
 *
 *  Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
 *
 *  Follow up:
 *  Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class LEET_501 {
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        minDiffInBST(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        minDiffInBST(root.right);
        return min;
    }
}
