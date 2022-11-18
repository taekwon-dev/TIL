package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_77 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> combination = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 0, 1);
        return result;
    }

    private void backtracking(int n, int k, int depth, int start) {
        if (depth == k) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i <= n; i++) {
            combination.add(i);
            backtracking(n, k, depth + 1, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
