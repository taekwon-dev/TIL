package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(k, n, result, list, 0, 1, 0);
        return result;
    }

    private void backtracking(int k, int n, List<List<Integer>> result, List<Integer> list, int depth, int index, int sum) {
        if (depth == k) {
            if (sum > n) {
                return;
            } else if (sum == n) {
                result.add(new ArrayList<>(list));
                return;
            }
        }
        for (int i = index; i <= 9; i++) {
            list.add(i);
            backtracking(k, n, result, list, depth + 1, i + 1, sum + i);
            list.remove(list.size() - 1);
        }
    }
}
