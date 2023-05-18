package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEET_90 {

    private List<List<Integer>> answer = new ArrayList<>();
    private List<Integer> candidate = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0, 0);
        return answer;
    }

    private void backtracking(int[] nums, int depth, int start) {
        answer.add(new ArrayList<>(candidate));

        int prev = -11;
        for (int i = start; i < nums.length; i++) {
            if (prev != nums[i]) {
                prev = nums[i];
                candidate.add(nums[i]);
                backtracking(nums, depth + 1, i + 1);
                candidate.remove(candidate.size() - 1);
            }
        }
    }
}