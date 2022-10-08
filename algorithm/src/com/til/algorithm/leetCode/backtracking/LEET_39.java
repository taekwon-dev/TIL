package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(candidates, target, result, list, 0, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int idx, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtracking(candidates, target, result, list, i, sum + candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
