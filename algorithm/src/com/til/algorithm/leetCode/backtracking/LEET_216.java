package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_216 {

    private List<List<Integer>> answer = new ArrayList<>();
    private List<Integer> candidate = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 0, 1, 0);
        return answer;
    }

    private void backtracking(int k, int n, int depth, int start, int sum) {
        if (depth == k) {
            if (sum == n) {
                answer.add(new ArrayList<>(candidate));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            candidate.add(i);
            backtracking(k, n, depth + 1, i + 1, sum + i);
            candidate.remove(candidate.size() - 1);
        }
    }
}