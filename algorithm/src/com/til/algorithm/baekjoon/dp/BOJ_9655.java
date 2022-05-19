package com.til.algorithm.baekjoon.dp;

import java.util.Scanner;

/**
 * Created by Youn on 2022/05/19.
 * Title : 돌 게임 (https://www.acmicpc.net/problem/9655)
 * Hint  :
 */
public class BOJ_9655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;
        }
        if (dp[n] % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
