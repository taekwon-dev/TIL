package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_216 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 0, 1, 0);
        return result;
    }

    private void backtracking(int k, int n, int depth, int start, int sum) {
        if (depth == k) {
            if (sum == n) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            backtracking(k, n,depth + 1, i + 1, sum + i);
            list.remove(list.size() - 1);
        }
    }
}
