package com.til.algorithm.baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Youn on 2022/05/18.
 * Title : 설탕 배달 (https://www.acmicpc.net/problem/2839)
 * Hint  : INF(무한), 보유한 단위의 봉지로 배달할 설탕 무게를 구성할 수 없는 경우를 의미한다.
 */
public class BOJ_2839 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = {-1, -1, -1, 1, -1, 1, 2, -1};

        if (n <= 7) {
            System.out.println(arr[n]);
            return;
        }
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 9999);
        dp[3] = 1;
        dp[5] = 1;
        dp[6] = 2;

        for (int i = 8; i < n + 1; i++) {
            dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
        }

        if (dp[n] == 9999) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n]);
        }
    }
}
