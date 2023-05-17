package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEET_39 {

    private List<List<Integer>> answer = new ArrayList<>();
    private List<Integer> candidate = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, 0);
        Arrays.sort(candidates);
        return answer;
    }

    private void backtracking(int[] candidates, int target, int sum, int start) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            answer.add(new ArrayList<>(candidate));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            candidate.add(candidates[i]);
            backtracking(candidates, target, sum + candidates[i], i);
            candidate.remove(candidate.size() - 1);
        }
    }
}