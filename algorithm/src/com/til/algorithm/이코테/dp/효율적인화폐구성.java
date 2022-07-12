package com.til.algorithm.이코테.dp;

import java.util.Arrays;
import java.util.Scanner;

public class 효율적인화폐구성 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[m + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        // O(N X M)
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                if (dp[j - arr[i]] != 10001) {
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }
        if (dp[m] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }
    }
}
