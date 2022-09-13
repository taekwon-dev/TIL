package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * - only character, lower or upper
 */
public class LEET_784_TEST {
    static String str = "a1b2c";
    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) {
        backtracking(0, 0, "");
        for (String s : answer) {
            System.out.println(s);
        }
    }

    private static void backtracking(int depth, int index, String s) {
        if (depth == str.length()) {
            answer.add(s);
            return;
        }
        for (int i = index; i < str.length(); i++) {
            backtracking(depth + 1, i + 1, s + Character.toLowerCase(str.charAt(i)));
            backtracking(depth + 1, i + 1, s + Character.toUpperCase(str.charAt(i)));
        }
    }

}
