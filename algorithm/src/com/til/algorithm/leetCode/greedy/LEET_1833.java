package com.til.algorithm.leetCode.greedy;

import java.util.Arrays;

public class LEET_1833 {

    public int maxIceCream(int[] costs, int coins) {
        int answer = 0;
        Arrays.sort(costs);
        if (coins < costs[0]) {
            return answer;
        }
        for (int cost : costs) {
            coins -= cost;
            if (coins < 0) {
                break;
            }
            answer++;
        }
        return answer;
    }
}