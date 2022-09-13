package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  Combination 3
 */
public class LEET_216 {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> curr = new ArrayList<>();
        backtracking(k, n, curr, 1, 1, 0);
        return answer;
    }
    private void backtracking(int k, int n, List<Integer> curr, int depth, int index, int sum) {
        if (depth == k + 1) {
            if (sum == n) {
                answer.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i = index; i <= 9; i++) {
            curr.add(i);
            backtracking(k, n, curr, depth + 1, i + 1, sum + i);
            curr.remove(curr.size() - 1);
        }
    }
}
