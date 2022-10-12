package com.til.algorithm.leetCode.tree;

public class LEET_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(nums, 0, nums.length - 1);
    }


    private TreeNode makeBST(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = (s + e) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeBST(nums, s, mid - 1);
        root.right = makeBST(nums, mid + 1, e);
        return root;
    }
}
