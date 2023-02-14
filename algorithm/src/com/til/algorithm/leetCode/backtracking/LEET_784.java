package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_784 {

    private List<String> answer = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        backtracking(s, 0, 0, "");
        return answer;
    }

    private void backtracking(String s, int depth, int index, String result) {
        if (depth == s.length()) {
            answer.add(result);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                backtracking(s, depth + 1, i + 1, result + s.charAt(i));
            } else {
                backtracking(s, depth + 1, i + 1, result + Character.toLowerCase(s.charAt(i)));
                backtracking(s, depth + 1, i + 1, result + Character.toUpperCase(s.charAt(i)));
            }
        }
    }
}
