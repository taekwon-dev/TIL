package com.til.algorithm.baekjoon.backtracking;

/**
 *  부분집합 나열하기
 */
public class BOJ_1182_TEST {
    static int[] arr = {1, 2, 3};
    public static void main(String[] args) {
        backtracking(0, "");
    }

    private static void backtracking(int depth, String num) {
        if (depth == 3) {
            if (num.equals("")) {
                System.out.println("∅");
            } else {
                System.out.println(num);
            }
            return;
        }
        backtracking(depth + 1, num);
        backtracking(depth + 1, num + arr[depth]);
    }

}
