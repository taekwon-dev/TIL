package com.til.algorithm.programmers.kit;

import java.util.Arrays;

public class LV1_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = 0;
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] != -1 && (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j])) {
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        return n - lost.length + answer;
    }
}
