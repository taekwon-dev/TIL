package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEET_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return answer;
        }
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        backtracking(nums, answer, subset, 0);
        return answer;
    }
    private void backtracking(int[] nums, List<List<Integer>> answer, List<Integer> subset, int start) {
        answer.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            backtracking(nums, answer, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
