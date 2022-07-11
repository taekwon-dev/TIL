package com.til.algorithm.이코테.dp;

import java.util.Scanner;

public class 금광 {

    static int tc, n, m;
    static int[][] arr = new int[20][20];
    static int[][] dp = new int[20][20];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();
        for (int t = 0; t < tc; t++) {
            n = sc.nextInt();
            m = sc.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; i < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; i < m; j++) {
                    dp[i][j] = arr[i][j];
                }
            }

            for (int j = 1; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    int leftUp, leftDown, left;

                    if (i == 0) leftUp = 0;
                    else leftUp = dp[i - 1][j - 1];

                    if (i == n - 1) leftDown = 0;
                    else leftDown = dp[i + 1][j - 1];

                    left = dp[i][j - 1];
                    dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(left, leftDown));
                }
            }
            int answer = 0;
            for (int i = 0; i < n; i++) {
                answer = Math.max(answer, dp[i][m - 1]);
            }
            System.out.println(answer);
        }
    }
}
