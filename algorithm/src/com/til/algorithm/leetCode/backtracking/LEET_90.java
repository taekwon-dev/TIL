package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEET_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(nums, result, list, 0);
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> list, int depth) {
        result.add(new ArrayList<>(list));
        int prev = -11;
        for (int i = depth; i < nums.length; i++) {
            if (prev != nums[i]) {
                prev = nums[i];
                list.add(nums[i]);
                backtracking(nums, result, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
