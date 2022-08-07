package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  연속합
 *
 *  N개의 정수 N(1 ≤ n ≤ 100,000), 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수
 *  우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
 *
 *  10, -4, 3, 1, 5, 6, -35, 12, 21, -1
 *
 *  에서 12 + 21 = 33 이 가장 큰 합
 *
 *  1, -2, 3, 4, 5, -6, 7
 *
 *  - 를 만났을 때 -> 기존 합 - ? < 0 인 경우, 그 다음부터 다시 시작
 *  1, 2, 3, 4, -11, 1, 2, 3, 11
 *
 *  DP[i] = i 까지의 연속 합 중 가장 큰 값
 *
 *
 */
public class BOJ_1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n + 1];
        dp[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

}
