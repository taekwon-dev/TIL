package com.til.algorithm.baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  Four Squares
 *
 *  25 = 5^2 -> 1
 *  26 = 5^2 + 1^2 -> 2
 *
 *  [25][26][27][28][29]
 *   1   2   2   2   2
 *
 *  DP + Brute Force
 */
public class BOJ_17626 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[0] = 0; // -> 1 초과하는 제곱수 (4, 9, 16 ...) 에서 활용
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - (j * j)]);
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[n]);
    }

}
