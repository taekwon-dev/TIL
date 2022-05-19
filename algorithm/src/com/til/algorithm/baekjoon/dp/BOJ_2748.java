package com.til.algorithm.baekjoon.dp;

import java.util.Scanner;

/**
 * Created by Youn on 2022/05/19.
 * Title : 피보나치 수 2 (https://www.acmicpc.net/problem/2748)
 * Hint  : int, long 경계를 알고 있으면 좋겠다.
 */
public class BOJ_2748 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
        sc.close();
    }


}
