package com.til.algorithm.baekjoon.backtracking;

/**
 *  중복된 문자열은 제거
 */
public class BOJ_6443_TEST2 {
    static char[] arr = {'a', 'b', 'b'};
    static boolean[] visited = new boolean[3];
    public static void main(String[] args) {
        backtracking(0, "");
    }

    private static void backtracking(int depth, String s) {
        if (depth == 3) {
            System.out.println(s);
            return;
        }
        char prev = 'A';
        for (int i = 0; i < 3; i++) {
            if (!visited[i] && prev != arr[i]) {
                visited[i] = true;
                prev = arr[i];
                backtracking(depth + 1, s + arr[i]);
                visited[i] = false;
            }
        }
    }

}
