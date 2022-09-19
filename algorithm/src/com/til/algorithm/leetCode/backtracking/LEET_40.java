package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEET_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(result, list, candidates, target, 0);
        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int s) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        int prev = 0;
        for (int i = s; i < candidates.length; i++) {
            if (prev != candidates[i]) {
                list.add(candidates[i]);
                prev = candidates[i];
                backtracking(result, list, candidates, target - candidates[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
