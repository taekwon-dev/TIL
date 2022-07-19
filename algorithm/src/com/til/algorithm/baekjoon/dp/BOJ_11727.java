package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  2 x n 타일링 2
 *  (1 ≤ n ≤ 1,000)
 *  2 x n 을
 *
 *  -  1 x 2
 *  -  2 x 1
 *  -  2 x 2
 *
 *  로 채우는 방법의 수
 *
 *  https://girawhale.tistory.com/34
 *
 *
 */
public class BOJ_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1000 + 1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}
