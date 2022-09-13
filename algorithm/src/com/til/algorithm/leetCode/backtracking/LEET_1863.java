package com.til.algorithm.leetCode.backtracking;

/**
 * Sum of All Subset XOR Totals
 */
public class LEET_1863 {
    public int subsetXORSum(int[] nums) {
        return backtracking(nums, 0, 0);
    }

    private int backtracking(int[] nums, int depth, int xors) {
        if (depth == nums.length) {
            return xors;
        }
        int a = backtracking(nums, depth + 1, xors);
        int b = backtracking(nums, depth + 1, nums[depth] ^ xors);
        return a + b;
    }
}
