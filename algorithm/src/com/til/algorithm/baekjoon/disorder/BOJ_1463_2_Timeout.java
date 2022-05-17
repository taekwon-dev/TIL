package com.til.algorithm.baekjoon.disorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Youn on 2022/05/13.
 * Title : 1로 만들기 (https://www.acmicpc.net/problem/1463)
 * Hint  : Top-down (재귀 활용) → Timeout
 */
public class BOJ_1463_2_Timeout {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        System.out.println(topDown(n));
    }

    private static int topDown(int n) {
        if (n == 1) return 0;
        if (dp[n] > 0) {
            return dp[n];
        }
        dp[n] = topDown(n - 1) + 1;

        if (n % 3 == 0) {
            dp[n] = Math.min(dp[n], dp[n / 3] + 1);
        }

        if (n % 2 == 0) {
            dp[n] = Math.min(dp[n], dp[n / 2] + 1);
        }
        return dp[n];
    }
}
