package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        List<Integer> subset = new ArrayList<>();
        backtracking(nums, results, subset, 0);
        return results;
    }

    private void backtracking(int[] nums, List<List<Integer>> results, List<Integer> subset, int start) {
        results.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtracking(nums, results, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
