package com.til.algorithm.baekjoon.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/13.
 * Title : 동전 2 (https://www.acmicpc.net/problem/2294)
 * Hint  : INF
 */
public class BOJ_2294 {

    static int n, k;
    static int[] coins;
    static int[] dp = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[k + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            // 화폐 단위보다 작은 타겟을 구성할 수 있는 방법이 없으므로,
            // 갖고 있는 화폐 단위를 기준으로 1씩 ++ 하면서 DP 테이블 구성
            for (int j = coins[i]; j < k + 1; j++) {
                if (dp[j - coins[i]] != 10001) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if (dp[k] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }



    }


}
