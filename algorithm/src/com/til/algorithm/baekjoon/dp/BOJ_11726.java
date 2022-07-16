package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  2 x n 타일링
 *
 *  2 x n (직사각형)
 *
 *  1 x 2, 2 x 1 타일로 채우는 방법의 수
 *
 *  마치 수능 수열 문제 풀듯이 나열 -> 규칙 찾기
 *  D[i] = D[i - 1] + D[i - 2] (i >= 3)
 *
 */
public class BOJ_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1000 + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}
