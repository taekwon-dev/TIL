package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  1, 2, 3 더하기
 *
 *  정수 4를 1, 2, 3 의 합으로 나타내는 방법 7 가지
 *
 *  - 1, 2, 3 중 한 개 이상 사용하는 조건
 *  - 같은 수를 여러 번 사용할 수 있다
 *  - 순서 의미 O
 *
 *  4 = 1 + 1 + 1 + 1
 *  4 = 1 + 1 + 2
 *  4 = 1 + 2 + 1
 *  4 = 1 + 3
 *  4 = 2 + 1 + 1
 *  4 = 2 + 2
 *  4 = 3 + 1
 *
 *  0 < N < 11
 *
 *  D[i] = i 를 나타낼 수 있는 방법
 *
 *  D[1] = {1} = 1
 *  D[2] = {1 + 1}, {2} = 2
 *  D[3] = {1 + 1 + 1}, {1 + 2}, {2 + 1}, {3} = 4
 *  D[4] = 7
 *
 *  D[4] = 4 + 2 + 1 = 7
 *
 *  1 + 3 -> D[3] = 4
 *  2 + 2 -> D[2] = 2
 *  3 + 1 -> D[1] = 1
 *
 *  D[5] = 7 + 4 + 2 = 13
 *
 *  1 + 4 -> D[4] = 7
 *  2 + 3 -> D[3] = 4
 *  3 + 2 -> D[2] = 2
 *
 *  D[N] =
 *
 *  1 + ? = D[?] 방식
 *  2 + ?
 *  3 + ?
 *
 *  Bottom Up
 *
 */
public class BOJ_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[10 + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());

            // 1 + ? = N -> ? = N - 1
            // D[N - 1]
            for (int i = 4; i < dp.length; i++) {
                for (int j = 1; j <= 3; j++) {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                }
            }
            System.out.println(dp[n]);
        }


    }
}
