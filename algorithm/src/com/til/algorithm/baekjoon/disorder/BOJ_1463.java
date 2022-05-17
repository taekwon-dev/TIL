package com.til.algorithm.baekjoon.disorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Youn on 2022/05/13.
 * Title : 1로 만들기 (https://www.acmicpc.net/problem/1463)
 * Hint  : Bottom-up (각 경우의 수를 아래부터 채워가면서 최종적인 답을 도출하는 과정)
 */
public class BOJ_1463 {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;

        /**
         *  dp[i] = dp[i - 1] + 1 (i >= 2)
         */
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[n]);
        br.close();
    }

}
