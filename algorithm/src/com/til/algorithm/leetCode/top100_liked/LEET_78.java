package com.til.algorithm.leetCode.top100_liked;

import java.util.ArrayList;
import java.util.List;

public class LEET_78 {

    private List<List<Integer>> subsets = new ArrayList<>();
    private List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return subsets;
    }

    private void backtracking(int[] nums, int depth) {
        if (depth == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[depth]);
        backtracking(nums, depth + 1);
        subset.remove(subset.size() - 1);

        backtracking(nums, depth + 1);
    }
}