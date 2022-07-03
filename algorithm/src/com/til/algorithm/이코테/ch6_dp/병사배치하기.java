package com.til.algorithm.이코테.ch6_dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Youn on 2022/05/13.
 * Title : 병사 배치하기 (https://www.youtube.com/watch?v=5Lu34WIx2Us)
 * Hint  : LIS (Longest Increasing Subsequence), 가장 긴 증가하는 부분 수열
 *
 *         부분 수열 : 부분 수열 또는 부분열은 주어진 수열의 일부 항을 원래 순서대로 나열하여 얻을 수 있는 수열이다.
 *         증가하는 부분 수열 : 수열의 부분 수열들 중, 오른차순으로 구성된 것들을 증가하는 부분 수열이라고 한다.
 *         가장 긴 증가하는 부분 수열 : 증가하는 부분 수열 중, 가장 사이즈가 큰 수열
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

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; 1 < n; i++) {
            for (int j = 0; j < i; j++) {
                if (v.get(j) < v.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(n - maxValue);
    }
}
