package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14916 {

    private static final int CANNOT_MAKE_CHANGE = -1;
    private static final int MAX = 100_001;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[MAX];

        dp[1] = CANNOT_MAKE_CHANGE;
        dp[2] = 1;
        dp[3] = CANNOT_MAKE_CHANGE;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i < MAX; i++) {
            if (dp[i - 2] == CANNOT_MAKE_CHANGE && dp[i - 5] == CANNOT_MAKE_CHANGE) {
                dp[i] = CANNOT_MAKE_CHANGE;
                continue;
            }
            if (dp[i - 2] == CANNOT_MAKE_CHANGE) {
                dp[i] = dp[i - 5] + 1;
                continue;
            }
            if (dp[i - 5] == CANNOT_MAKE_CHANGE) {
                dp[i] = dp[i - 2] + 1;
                continue;
            }
            dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
        }
        System.out.println(dp[n]);
    }
}
