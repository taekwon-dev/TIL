package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEET_40 {

    private List<List<Integer>> answer = new ArrayList<>();
    private List<Integer> candidate = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return answer;
    }

    private void backtracking(int[] candidates, int target, int start, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            answer.add(new ArrayList<>(candidate));
        }
        int prev = -1;
        for (int i = start; i < candidates.length; i++) {
            if (prev == candidates[i]) {
                continue;
            }
            prev = candidates[i];
            candidate.add(candidates[i]);
            backtracking(candidates, target, i + 1, sum + candidates[i]);
            candidate.remove(candidate.size() - 1);
        }
    }
}