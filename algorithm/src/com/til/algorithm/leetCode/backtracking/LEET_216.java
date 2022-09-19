package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(result, list, k, n, 0, 1, 0);
        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> list, int k, int n, int depth, int start, int sum) {
        if (depth == k) {
            if (sum == n) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            backtracking(result, list, k, n, depth + 1, i + 1, sum + i);
            list.remove(list.size() - 1);
        }
    }
}
