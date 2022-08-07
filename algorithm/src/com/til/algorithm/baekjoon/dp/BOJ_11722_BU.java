package com.til.algorithm.baekjoon.dp;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 긴 감소하는 부분 수열
 *
 *  A = {10, 30, 10, 20, 20, 10} 인 경우에
 *  가장 긴 감소하는 부분 수열은 A = {30, 20, 10}  이고, 길이는 3이다.
 *
 *  10 -> 1
 *  30 -> 1 (앞 인덱스에 30보다 작은 수가 없음)
 *  10 -> 2
 *  20 -> 2
 *  20 -> 2 (같은 수의 경우 결과 값이 같음)
 *  10 -> 3
 *
 *
 */
public class BOJ_11722_BU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                } else if (arr[j] == arr[i]) {
                    dp[i] = dp[j];
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
