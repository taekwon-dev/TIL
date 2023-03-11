package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_39 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> combination = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int start, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtracking(candidates, target, i, sum + candidates[i]);
            combination.remove(combination.size() - 1);
        }
    }
}
