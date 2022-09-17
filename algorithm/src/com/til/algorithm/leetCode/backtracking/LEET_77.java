package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> combi = new ArrayList<>();
        backtracking(n, k, results, combi, 0, 1);
        return results;
    }

    private void backtracking(int n, int k, List<List<Integer>> results, List<Integer> combi, int depth, int start) {
        if (depth == k) {
            results.add(new ArrayList<>(combi));
            return;
        }

        for (int i = start; i <= n; i++) {
            combi.add(i);
            backtracking(n, k, results, combi, depth + 1, i + 1);
            combi.remove(combi.size() - 1);
        }
    }
}
