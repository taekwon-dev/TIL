package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
    static int tc, n, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            n = Integer.parseInt(br.readLine());
            backtracking(0);
            System.out.println(answer);
            answer = 0;
        }
    }

    private static void backtracking(int sum) {
        if (sum > n) return;
        if (sum == n) {
            answer++;
            return;
        }
        for (int i = 1; i <= 3; i++) {
            backtracking(sum + i);
        }
    }
}
