package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  Power Set with no duplicates ex) {1, 2, 3}
 */
public class LEET_90_TEST {
    static int[] nums = {1, 2, 3};
    static List<List<Integer>> subsets = new ArrayList<>();
    static List<Integer> subset = new ArrayList<>();

    public static void main(String[] args) {
        backtracking(nums, subsets, subset, 0);
        System.out.println(subsets);
    }

    private static void backtracking(int[] nums, List<List<Integer>> subsets, List<Integer> subset, int start) {
        subsets.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtracking(nums, subsets, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
