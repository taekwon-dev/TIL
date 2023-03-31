package com.til.algorithm.baekjoon.dp;

import java.io.*;

public class BOJ_10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][10];
        long mod = 1_000_000_000;

        /**
         *  첫 번째 자리 수는 0이 올 수 없다.
         */
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        /**
         *  두 번째 자리 수부터는 0 ~ 9 사이의 값이 올 수 있다.
         */
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % mod;
                } else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[N][i];
        }

        bw.write(answer % mod + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}