package com.til.algorithm.leetCode.top75.dp;

import java.util.Arrays;

/**
 *   Coin Change
 *
 *   Return the fewest number of coins that you need to make up that amount
 *   If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 *   1 <= N = coins.length <= 12
 *   0 <= M = amount <= 10000
 *   O (N * M) = 각 코인 단위 별로 1 ~ M 를 구성하는 방법을 업데이트
 *
 *   Ai = 금액 i 를 만들 수 있는 최소한의 화폐 개수
 *   k = 각 화폐의 단위
 *
 *   각 화폐 단위 별로,
 *   Ai-k 를 만드는 방법이 존재하는 경우 -> Ai = min(Ai, Ai-k + 1)
 *   Ai-k 를 만드는 방법이 존재하지 않는 경우 -> Ai = INF
 *
 */

public class LEET_322 {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        // O (N * N)
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != 10001) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        if (dp[amount] == 10001) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}
