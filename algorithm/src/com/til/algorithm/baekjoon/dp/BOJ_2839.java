package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *  설탕 배달
 *
 *  3 <= N <= 5000
 *
 *  단위 3 or 5
 *  더 적은 설탕 봉지 수로 N 만큼 구성하는 문제
 *  (3, 5 단위로 N을 구성할 수 없는 경우 -1 출력)
 *
 *  18 -> 5 * 3 + 3 * 1 = 4
 *
 *  1 -> -1
 *  2 -> -1
 *  3 -> 1
 *  4 -> -1
 *  5 -> 1
 *  6 -> 1 + 1 = 2
 *  7 -> -1
 */

public class BOJ_2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = {-1, -1, -1, 1, -1, 1, 2, -1};
        if (n < 8) {
            System.out.println(arr[n]);
            return;
        }
        int[] dp = new int[5000 + 1];
        Arrays.fill(dp, 5001);
        dp[3] = 1;
        dp[5] = 1;
        dp[6] = 2;
        for (int i = 8; i < 5001; i++) {
            dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
        }

        if (dp[n] == 5001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n]);
        }
    }
}
