package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_78_a {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int depth) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[depth]);
        backtracking(nums, depth + 1);
        subset.remove(subset.size() - 1);

        backtracking(nums, depth + 1);
    }
}
