package com.til.algorithm.leetCode.dp;

public class LEET_TD_70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return helper(n, dp);
    }

    private int helper(int n, int[] dp) {
        if (n == 0 || n == 1) return 1;
        if (dp[n] != 0) return dp[n];
        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        return dp[n];
    }
}
