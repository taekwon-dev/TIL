package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974 {

    private static int n;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        backtracking(0, "");
    }

    private static void backtracking(int depth, String s) {
        if (depth == n) {
            System.out.println(s);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, s + i + " ");
                visited[i] = false;
            }
        }
    }
}