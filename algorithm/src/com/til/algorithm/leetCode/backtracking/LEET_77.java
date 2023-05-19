package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_77 {

    private List<List<Integer>> answer = new ArrayList<>();
    private List<Integer> candidate = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 0, 1);
        return answer;
    }

    private void backtracking(int n, int k, int depth, int start) {
        if (depth == k) {
            answer.add(new ArrayList<>(candidate));
            return;
        }
        for (int i = start; i <= n; i++) {
            candidate.add(i);
            backtracking(n, k, depth + 1, i + 1);
            candidate.remove(candidate.size() - 1);
        }
    }
}