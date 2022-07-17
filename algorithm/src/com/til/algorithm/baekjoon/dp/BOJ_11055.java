package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  가장 큰 증가 부분 수열
 *
 *  수열 A가 주어졌을 때, 그 수열의 증가 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램을 작성하시오.
 *  수열 A의 크기 N (1 ≤ N ≤ 1,000)
 *
 *  {1, 100, 2, 50, 60, 3, 5, 6, 7, 8}
 *
 *  1, 2, 50, 60 = 113 (1, 2, 50, 60 순서는 유지)
 *
 *  D[i] = i를 마지막 원소로 갖는 가지는 부분 수열의 최대 합 (각 원소의 합)
 */
public class BOJ_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    // max 함수를 써야 하는 예시
                    // 2, 1, 5, 6, 7
                    // 5 입장에서 2 , 1 모두 5 보다 작으므로 합이 증가하는 수열 대상인데,
                    // 2 + 5(7), 1 + 5(6) 중 큰 수를 지정하지 않으면 6 으로 지정이 된다. (overwrite)
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }
}
