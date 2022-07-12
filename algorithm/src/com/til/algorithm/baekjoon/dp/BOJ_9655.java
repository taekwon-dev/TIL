package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  돌 게임
 *
 *  두 명이서 플레이
 *
 *  한 턴 당 1개 또는 3개의 돌을 가지고 오고, 마지막 돌을 가지고 오는 사람이 승리
 *
 *  Players = {SK, CY}
 *  SK 선
 *
 *  1 <= N (돌의 개수) <= 1000
 *
 */
public class BOJ_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1000 + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
        }

        if (dp[n] % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
