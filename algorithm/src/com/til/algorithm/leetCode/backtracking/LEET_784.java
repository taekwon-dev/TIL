package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_784 {

    private List<String> answer = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        backtracking(s, 0, "");
        return answer;
    }

    private void backtracking(String s, int idx, String candidate) {
        if (idx == s.length()) {
            answer.add(candidate);
            return;
        }
        if (Character.isDigit(s.charAt(idx))) {
            backtracking(s, idx + 1, candidate + s.charAt(idx));
        } else {
            backtracking(s, idx + 1, candidate + Character.toLowerCase(s.charAt(idx)));
            backtracking(s, idx + 1, candidate + Character.toUpperCase(s.charAt(idx)));
        }
    }
}