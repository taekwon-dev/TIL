package com.til.algorithm.leetCode.tree;

/**
 *  Binary Search Tree + in order (오름차순)
 *  - 모든 노드를 탐색 기반 방식
 */
public class LEET_938_a {

    private int rangeSum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root, low, high);
        return rangeSum;
    }

    private void inorder(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        inorder(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            rangeSum += root.val;
        }
        inorder(root.right, low, high);
    }
}