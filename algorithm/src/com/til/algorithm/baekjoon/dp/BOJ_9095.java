package com.til.algorithm.baekjoon.dp;

import java.io.*;

public class BOJ_9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        int N = 0;
        while (TC-- > 0) {
            N = Integer.parseInt(br.readLine());
            bw.write(dp[N] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}