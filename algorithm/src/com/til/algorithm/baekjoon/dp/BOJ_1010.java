package com.til.algorithm.baekjoon.dp;

import java.util.Scanner;

/**
 * Created by Youn on 2022/05/19.
 * Title : 다리 놓기 (https://www.acmicpc.net/problem/1010)
 * Hint  : 조합 (Combination)
 */
public class BOJ_1010 {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            for (int i = 0; i < dp.length; i++) {
                dp[i][i] = 1;
                dp[i][0] = 1;
            }

            for (int i = 2; i < dp.length; i++) {
                for (int j = 1; j < dp.length; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i -1][j];
                }
            }

            System.out.println(dp[m][n]);
        }
    }
}
