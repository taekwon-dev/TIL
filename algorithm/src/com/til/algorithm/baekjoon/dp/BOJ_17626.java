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
 *  1 = 1^2              -> 1
 *  2 = 1^2 + 1^2        -> 2
 *  3 = 1^2 + 1^2 + 1^2  -> 3
 *  -------
 *  4 = 2^2                    -> 1
 *  5 = 2^2 + 1^2              -> 2
 *  6 = 2^2 + 1^2 + 1^2        -> 3
 *  7 = 2^2 + 1^2 + 1^2 + 1^2  -> 4
 *  8 = 2^2 + 2^2              -> 2
 *  -------
 *  9 = 3^2                    -> 1
 *  10 = 3^2 + 1^2             -> 2
 *  11 = 3^2 + 1^2 + 1^2       -> 3
 *  12 = 3^2 + 1^2 + 1^2 + 1^2 -> 4
 *  13 = 3^2 + 2^2             -> 2
 *  14 = 3^2 + 2^2 + 1^2       -> 3
 *  15 = 3^2 + 2^2 + 1^2 + 1^2 -> 4
 *  -------
 *  16 = 4^2
 *  -------
 *  25 = 5^2
 *
 *  제곱수는 하나로 구성되는 것 확인 -> 메모지에이션
 *
 *
 *  나열 -> 점화식 추출
 *  n을 최소 개수의 제곱수 합으로 표현
 *
 *  d[1] = 1
 *  d[2] = d[1] + 1
 *  d[3] = d[2] + 1
 *  ----------------
 *  d[4] = 1
 *  d[5] = d[4] + 1
 *  d[6] = d[5] + 1
 *  d[7] = d[6] + 1 (❗️ >= 4 )
 *  d[8] = d[4] + 1
 *  ----------------
 *  d[9] = 1
 *  d[10] = d[9] + 1
 *  d[11] = d[10] + 1
 *  d[12] = d[11] + 1 (❗️ >= 4 )
 *  d[13] = d[9] + 1
 *  d[14] = d[13] + 1
 *  d[15] = d[14] + 1
 *  ----------------
 *  [16] = 1
 *  .
 *  .
 *  d[i] = d[i - 1] + 1 (i >= 2,  d[i - 1] < 5 )
 *  d[i] = d[i와 가장 가까운 제곱수] + 1
 */

public class BOJ_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        // i j
        // 2 1
        // 3 1
        // 4 1,2
        // 5 1,2
        // 6 1,2
        // 7 1,2
        // 8 1,2
        // 9 1,2,3
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                System.out.println("i = " + i + " min = " + min + " dp[i - (j * j)] = " + dp[i - (j * j)]);
                min = Math.min(min, dp[i - (j * j)]);
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[n]);
    }

    /**
     n = 8
     i = 2 min = 2147483647 dp[i - (j * j)] = 1
     i = 3 min = 2147483647 dp[i - (j * j)] = 2

     i = 4 min = 2147483647 dp[i - (j * j)] = 3
     i = 4 min = 3 dp[i - (j * j)] = 0

     i = 5 min = 2147483647 dp[i - (j * j)] = 1
     i = 5 min = 1 dp[i - (j * j)] = 1

     i = 6 min = 2147483647 dp[i - (j * j)] = 2
     i = 6 min = 2 dp[i - (j * j)] = 2

     i = 7 min = 2147483647 dp[i - (j * j)] = 3
     i = 7 min = 3 dp[i - (j * j)] = 3

     i = 8 min = 2147483647 dp[i - (j * j)] = 4
     i = 8 min = 4 dp[i - (j * j)] = 1
     */

}
