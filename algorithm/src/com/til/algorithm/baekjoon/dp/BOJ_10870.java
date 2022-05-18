package com.til.algorithm.baekjoon.dp;

import java.util.Scanner;

/**
 * Created by Youn on 2022/05/18.
 * Title : 피보나치 수 5 (https://www.acmicpc.net/problem/10870)
 * Hint  :
 */
public class BOJ_10870 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            if (i == 0) {
                dp[0] = 0;
            } else if (i == 1) {
                dp[1] = 1;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        System.out.println(dp[n]);
    }

    // 재귀
    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
