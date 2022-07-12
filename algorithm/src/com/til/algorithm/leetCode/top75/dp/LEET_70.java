package com.til.algorithm.leetCode.top75.dp;

/**
 *  Climbing Stairs
 *
 *
 *
 *  1 or 2 steps (to the top)
 *
 *  it will take `n` steps  ( 1 <= n <= 45 )
 *
 *
 *  In how many distinct ways can you climb to the top? ( 경우의 수 )
 *
 *
 *  가장 마지막 시점을 생각해보자.
 *
 *  n = 1
 *
 *  0 -> 한 칸을 올라가서 -> 1
 *  dp[1] = 1
 *  dp[2] = 2
 *
 *  n = 10
 *
 *  8 -> 두 칸을 올라가서 -> 10
 *  9 -> 한 칸을 올라가서 -> 10
 *
 *  dp[i] = dp[i - 1] + dp[i - 2] (i > 2)
 *
 */
public class LEET_70 {

    class Solution {
        /**
         *  Bottom - Up
         */
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;

            /**
             *  N = 1 인 경우 인덱스 범위 에러 발생
             *
             */
//            dp[2] = 2;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

        /**
         *  Top - Down
         *
         */
        public int[] dp;
        public int climbStairs2(int n) {
            dp = new int[n + 1];
            return dprecurr(n);
        }

        public int dprecurr(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }
            if (dp[n] != 0) {
                return dp[n];
            }
            dp[n] = dprecurr(n - 1) + dprecurr(n - 2);
            return dp[n];
        }
    }
}
