package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 */
public class LEET_22 {
    static List<String> answer = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        backtracking(n, 0, 0, "");
        return answer;
    }

    private static void backtracking(int n, int open, int close, String str) {
        if (open == n && close == n) {
            answer.add(str);
            return;
        }
        if (open < n) {
            backtracking(n, open + 1, close, str + "(");
        }
        if (open > close) {
            backtracking(n, open, close + 1, str + ")");
        }
    }

    public static void main(String[] args) {
        generateParenthesis(2);
    }
}
