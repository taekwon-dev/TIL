package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_22 {

    private List<String> answer = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtracking(n, 0, 0, "");
        return answer;
    }

    private void backtracking(int n, int open, int close, String candidate) {
        if (open == n && close == n) {
            answer.add(candidate);
            return;
        }
        if (open < n) {
            backtracking(n, open + 1, close, candidate + "(");
        }
        if (open > close) {
            backtracking(n, open, close + 1, candidate + ")");
        }
    }
}