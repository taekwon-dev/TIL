package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  가장 긴 증가하는 부분 수열 (LIS, Longest Increasing Subsequence)
 *
 *  A = {10, 20, 10, 30, 20, 50} 에서
 *  가장 긴 증가하는 수열 A = {10, 20, 30, 50}
 *
 *  수열 A의 크기 N (1 ≤ N ≤ 1,000)
 *  수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
 *
 *
 *  A = {10, 20, 10, 30, 20, 50}
 *
 *  DP[1] = 1
 *  DP[2] = 2
 *  DP[3] = 1
 *  DP[4] = 3
 *  DP[5] = 2
 *  DP[6] = 4
 *
 *  " 부분 집합 최소 길이 1 "
 *
 */
public class BOJ_11503_BU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // 각 원소만 갖는 부분집합의 길이는 1
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 1;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}
