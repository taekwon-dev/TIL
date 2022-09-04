package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  Combination Sum
 */
public class LEET_39 {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, 0);
        return answer;
    }

    private void backtracking(int[] candidates, int target, int index, int sum) {
        if (sum > target) return;
        if (sum == target) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtracking(candidates, target, i, sum + candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
