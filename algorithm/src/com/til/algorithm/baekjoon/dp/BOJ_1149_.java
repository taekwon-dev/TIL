package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_ {
    static int n;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        cost = new int[n + 1][4];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n + 1][4];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];
        dp[1][3] = cost[1][3];

        for (int i = 2; i <= n; i++) {
            dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][3]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][3]) + cost[i][2];
            dp[i][3] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][3];
        }
        int answer = Math.min(dp[n][1], Math.min(dp[n][2], dp[n][3]));
        System.out.println(answer);
    }
}
