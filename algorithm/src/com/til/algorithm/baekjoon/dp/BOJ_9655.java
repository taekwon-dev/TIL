package com.til.algorithm.baekjoon.dp;

import java.io.*;

public class BOJ_9655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;

        for (int i = 4; i <= 1000; i++) {
            dp[i] = dp[i - 1] + 1;
        }

        if (dp[N] % 2 != 0) {
            bw.write("SK" + "\n");
        } else {
            bw.write("CY" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}