package com.til.algorithm.leetCode.top75.dp;


import java.util.Arrays;

/**
 *  Longest Increasing Subsequence (LIS) : 가장 긴 증가하는 부분 수열
 *
 *  Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 *  DP[i] = Arr[i]를 마지막 원소로 가지는 부분수열의 최대 길이
 *  0 <= j < i and DP[i] = Max(DP[i], DP[j] + 1) If, Arr[j] < Arr[i]
 */
public class LEET_300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        // 길이가 1인 부분 집합 (각 원소 기준)
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


}
