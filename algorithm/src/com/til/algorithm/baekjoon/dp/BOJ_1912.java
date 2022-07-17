package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  연속합
 *
 *  https://www.youtube.com/watch?v=OxsZKLfaWX0
 *  = 최대 연속 부분수열의 합
 *
 *  N 개의 정수로 이루어진 임의의 수열 n(1 ≤ n ≤ 100,000)
 *  수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수
 *
 *  연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
 *  단, 수는 한 개 이상 선택해야 한다.
 *
 *  dp[n] = max(dp[n - 1] + cost[n], cost[n])
 *
 *
 */
public class BOJ_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

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
