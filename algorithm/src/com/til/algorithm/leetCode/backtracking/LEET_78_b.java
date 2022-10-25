package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_78_b {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(nums, result, list, 0);
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> list, int depth) {
        result.add(new ArrayList<>(list));
        for (int i = depth; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
