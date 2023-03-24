package com.til.algorithm.leetCode.top100_liked;

import java.util.ArrayList;
import java.util.List;

public class LEET_39 {

    private List<List<Integer>> combinations = new ArrayList<>();
    private List<Integer> combination = new ArrayList<>();
    private int[] candidates;
    private int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        backtracking(0, 0, 0);
        return combinations;
    }

    private void backtracking(int depth, int start, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtracking(depth + 1, i, sum + candidates[i]);
            combination.remove(combination.size() - 1);
        }
    }
}