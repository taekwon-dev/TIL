package com.til.algorithm.baekjoon.dp;

import java.io.*;

public class BOJ_15988 {

    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        int[] dp = new int[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 1_000_000; i++) {
            dp[i] += dp[i - 3];
            dp[i] %= MOD;
            dp[i] += dp[i - 2];
            dp[i] %= MOD;
            dp[i] += dp[i - 1];
            dp[i] %= MOD;
        }

        while (TC-- > 0) {
            int N = Integer.parseInt(br.readLine());
            bw.write(dp[N] + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}