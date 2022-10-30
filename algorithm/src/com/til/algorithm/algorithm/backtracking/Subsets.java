package com.til.algorithm.algorithm.backtracking;

public class Subsets {
    public static void main(String[] args) {
        String order = "ABCDE";
        backtracking(order.toCharArray(), 0, "");
    }

    private static void backtracking(char[] menu, int depth, String s) {
        if (depth == menu.length) {
            if (s.length() >= 2) {
                System.out.println(s);
            }
            return;
        }
        backtracking(menu, depth + 1, s + menu[depth]);
        backtracking(menu, depth + 1, s);
    }
}
