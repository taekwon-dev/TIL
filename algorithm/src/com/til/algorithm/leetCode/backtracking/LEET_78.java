package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_78 {

    private List<List<Integer>> answer = new ArrayList<>();
    private List<Integer> candidate = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return answer;
    }

    private void backtracking(int[] nums, int idx) {
        if (idx == nums.length) {
            answer.add(new ArrayList<>(candidate));
            return;
        }
        candidate.add(nums[idx]);
        backtracking(nums, idx + 1);
        candidate.remove(candidate.size() - 1);

        backtracking(nums, idx + 1);
    }
}