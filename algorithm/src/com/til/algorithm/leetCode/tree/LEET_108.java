package com.til.algorithm.leetCode.tree;

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
