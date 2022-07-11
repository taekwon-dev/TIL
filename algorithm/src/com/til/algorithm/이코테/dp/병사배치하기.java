package com.til.algorithm.이코테.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *  가장 긴 증가하는 부분 수열 (LIS)
 *  가장 긴 감소하는 부분 수열 (내림차순)
 *
 */

public class 병사배치하기 {

    static int n;
    static ArrayList<Integer> v = new ArrayList<>();
    static int[] dp = new int[2000];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            v.add(sc.nextInt());
        }
        Collections.reverse(v);
        for (int i = 0; i < n; i++) dp[i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (v.get(j) < v.get(i)) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(n - max); // 열외 된 병사 수
    }
}
