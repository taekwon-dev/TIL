package com.til.algorithm.programmers.kit;

public class LV2_주식가격 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int j = i + 1;
            int span = 0;
            while (j < prices.length) {
                if (prices[i] > prices[j]) {
                    span++;
                    break;
                }
                j++;
                span++;
            }
            answer[i] = span;
        }
        return answer;
    }
}