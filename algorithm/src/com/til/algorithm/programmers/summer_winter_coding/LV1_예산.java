package com.til.algorithm.programmers.summer_winter_coding;

import java.util.Arrays;

public class LV1_예산 {

    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int answer = 0;
        int sum = 0;
        for (int apply : d) {
            sum += apply;
            if (sum > budget) {
                break;
            }
            answer++;
        }
        return answer;
    }
}