package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  Letter Case Permutations
 */
public class LEET_784 {
    public List<String> letterCasePermutation(String s) {
        List<String> answer = new ArrayList<>();
        backtracking(answer, s, 0, 0, "");
        return answer;
    }
    private void backtracking(List<String> answer, String s, int depth, int index, String item) {
        if (depth == s.length()) {
            answer.add(item);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                backtracking(answer, s, depth + 1, i + 1, item + Character.toLowerCase(s.charAt(i)));
                backtracking(answer, s, depth + 1, i + 1, item + Character.toUpperCase(s.charAt(i)));
            } else {
                backtracking(answer, s, depth + 1, i + 1, item + s.charAt(i));
            }
        }
    }
}
