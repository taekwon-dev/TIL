package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  피보나치 수 5
 *
 *  n 번째 피보나치 수 구하기
 *  0 <= n <= 20
 *
 *  Top-Down via recursion
 */
public class BOJ_10870_TD {

    static int n;
    static int[] dp = new int[21];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return dp[n];
    }

}
