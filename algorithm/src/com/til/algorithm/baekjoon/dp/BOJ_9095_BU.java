package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1, 2, 3 더하기
 *
 *  4
 *  1 + 1 + 1 + 1
 *  1 + 1 + 2
 *  1 + 2 + 1
 *  2 + 1 + 1
 *  2 + 2
 *  1 + 3
 *  3 + 1
 *
 *  d[1] = 1 -> 1
 *  d[2] = 2 -> 1 + 1, 2
 *  d[3] = 4 -> 1 + 1 + 1, 1 + 2, 2 + 1, 3
 *  d[4] = 7 -> 1 + 1 + 1 + 1, ...
 *
 *  d[i] = d[i - 3] + d[i - 2] + d[i - 1] (i >=4)
 */
public class BOJ_9095_BU {
    static int[] dp = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
