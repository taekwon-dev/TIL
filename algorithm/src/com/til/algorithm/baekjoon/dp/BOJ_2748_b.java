package com.til.algorithm.baekjoon.dp;

import java.io.*;

public class BOJ_2748_b {

    private static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;

        bw.write(fibonacci(N) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long fibonacci(int N) {
        if (dp[N] == -1) {
            dp[N] = fibonacci(N - 1) + fibonacci(N - 2);
        }
        return dp[N];
    }
}