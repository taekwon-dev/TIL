package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_78_a {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(nums, result, list, 0);
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> list, int depth) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[depth]);
        backtracking(nums, result, list, depth + 1);
        list.remove(list.size() - 1);
        backtracking(nums, result, list, depth + 1);
    }
}
