package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 *  조합 (Combination)
 *
 *  n과 m이 주어진다. (5 ≤ n ≤ 100, 5 ≤ m ≤ 100, m ≤ n)
 *
 *  nCm 출력
 *
 *  n+1Cr+1 = nCr + nCr+1
 *
 *  5C3 = 4C2 + 4C3
 *  (10)  (6)   (4)
 *
 *  5C5 = 4C4 + 4C5
 *  (1)
 *
 *  DP[i][j] = iCj 값
 *
 *  DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j]
 */
public class BOJ_2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger[][] dp = new BigInteger[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = BigInteger.ONE;
                } else {
                    dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
