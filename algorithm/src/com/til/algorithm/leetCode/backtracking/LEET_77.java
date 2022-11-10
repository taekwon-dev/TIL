package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(n, k, result, list, 0, 1);
        return result;
    }

    private void backtracking(int n, int k, List<List<Integer>> result, List<Integer> list, int depth, int start) {
        if (depth == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtracking(n, k, result, list, depth + 1, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
