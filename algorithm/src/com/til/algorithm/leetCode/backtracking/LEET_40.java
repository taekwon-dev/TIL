package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEET_40 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int start, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        int prev = 0;
        for (int i = start; i < candidates.length; i++) {
            if (prev != candidates[i]) {
                prev = candidates[i];
                list.add(candidates[i]);
                backtracking(candidates, target, i + 1, sum + candidates[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}
