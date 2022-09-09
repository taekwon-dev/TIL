package com.til.algorithm.baekjoon.backtracking;

public class BOJ_6443_TEST {
    static int[] arr = {1, 2, 3};
    static boolean[] visited = new boolean[3];
    public static void main(String[] args) {
        backtracking(0, "");
    }

    private static void backtracking(int depth, String s) {
        if (depth == 3) {
            System.out.println(s);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, s + arr[i]);
                visited[i] = false;
            }
        }
    }

}
