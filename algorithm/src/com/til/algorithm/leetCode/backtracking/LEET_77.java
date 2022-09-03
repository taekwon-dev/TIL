package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  Combinations
 *
 */
public class LEET_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(answer, list, n, k, 0, 1);
        return answer;
    }

    private void backtracking(List<List<Integer>> answer, List<Integer> list, int n, int k, int depth, int index) {
        if (depth == k) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            backtracking(answer, list, n, k, depth + 1, i + 1);
            list.remove(list.size() -1);
        }
    }
}
