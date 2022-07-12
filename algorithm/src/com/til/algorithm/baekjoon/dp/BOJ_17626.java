package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  Four Squares
 *  라그랑주는 1770년에 모든 자연수는 넷 혹은 그 이하의 제곱수의 합으로 표현할 수 있다고 증명하였다.
 *
 *  26 = 5^2 + 1^2
 *  26 = 4^2 + 3^2 + 1^2
 *
 *  자연수 n이 주어질 때, n을 최소 개수의 제곱수 합으로 표현하는 컴퓨터 프로그램을 작성하시오.
 *
 *  1 <= n <= 50000
 *
 *
 *  1 = 1^2
 *  4 = 2^2
 *  9 = 3^2
 *  16 = 4^2
 *  25 = 5^2
 *
 *  제곱수는 하나로 구성되는 것 확인 -> 메모지에이션
 *
 *  2 = 1 + 1 = 2
 *  3 = 1 + 1 + 1 = 3
 *  5 = 4 + 1 = 2
 *  .
 *  .
 *  .
 *  26 = 25 + 1 = 2
 *  27 = 25 + 2 = 25 + 1 + 1 = 3
 *  28 = 25 + 3 = 25 + 1 + 1 + 1 = 4
 *  29 = 25 + 4 = 2
 *
 *  나열 -> 점화식 추출
 *
 */

public class BOJ_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - (j * j)]);
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[n]);
    }
}
