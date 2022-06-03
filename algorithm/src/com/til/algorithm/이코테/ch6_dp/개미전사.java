package com.til.algorithm.이코테.dp;

import java.util.Scanner;

/**
 * Created by Youn on 2022/05/12.
 * Title : 개미 전사 (https://www.youtube.com/watch?v=5Lu34WIx2Us)
 * Hint  :
 */
public class 개미전사 {

    public static int[] dp = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        System.out.println(dp[n - 1]);

    }

}
