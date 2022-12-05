package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(n, result, 0, 0, "");
        return result;
    }

    private void backtracking(int n, List<String> result, int open, int close, String s) {
        if (open == n && close == n) {
            result.add(s);
            return;
        }
        if (open < n) {
            backtracking(n, result, open + 1, close, s + "(");
        }
        if (open > close) {
            backtracking(n, result, open, close + 1, s + ")");
        }
    }
}
