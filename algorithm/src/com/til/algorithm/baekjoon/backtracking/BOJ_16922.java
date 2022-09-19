package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16922 {
    static int n;
    static int[] arr = {1, 5, 10, 50};
    static boolean[] visited = new boolean[1000 + 1];
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        backtracking(0, 0, 0);
        System.out.println(answer);
    }

    private static void backtracking(int depth, int index, int sum) {
        if (depth == n) {
            if (!visited[sum]) {
                visited[sum] = true;
                answer++;
            }
            return;
        }
        for (int i = index; i < 4; i++) {
            backtracking(depth + 1, i, sum + arr[i]);
        }
    }
}
