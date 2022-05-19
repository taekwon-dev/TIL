package com.til.algorithm.baekjoon.dp;

import java.util.Scanner;

/**
 * Created by Youn on 2022/05/19.
 * Title : FourSquares (https://www.acmicpc.net/problem/17626)
 * Hint  : 나열하고 규칙을 찾는다. (점화식) / 발견한 특징을 점화식으로 나타내는 과정에서 실패
 */
public class BOJ_17626 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[n]);
    }
}
