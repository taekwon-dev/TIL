package com.til.algorithm.baekjoon.dp;

import java.io.*;
import java.util.Arrays;

public class BOJ_2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = {-1, -1, -1, 1, -1, 1, 2, -1};

        if (N < 8) {
            bw.write(dp[N] + "\n");
        } else {
            dp = new int[5001];
            Arrays.fill(dp, 5001);
            dp[3] = 1;
            dp[5] = 1;
            dp[6] = 2;

            for (int i = 8; i <= 5000; i++) {
                dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
            }

            if (dp[N] == 5001) {
                bw.write(-1 + "\n");
            } else {
                bw.write(dp[N] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}