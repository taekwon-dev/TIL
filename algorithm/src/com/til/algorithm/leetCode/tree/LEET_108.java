package com.til.algorithm.leetCode.tree;

/**
 *  Converted Sorted Array to Binary Search Tree
 *
 *  Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 *  오름차순으로 정렬된 배열 -> BST
 */
public class LEET_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(nums, 0, nums.length - 1);
    }

    private TreeNode makeBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = makeBST(nums, start, mid - 1);
        node.right = makeBST(nums, mid + 1, end);
        return node;
    }
}
