package com.til.algorithm.programmers.kit;

import java.util.Arrays;

public class LV1_체육복 {

    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int answer = n;
        int[] student = new int[n];
        for (int l : lost) {
            student[l - 1]--;
        }
        for (int r : reserve) {
            student[r - 1]++;
        }

        for (int i = 0; i < student.length; i++) {
            if (student[i] == -1) {
                if (i - 1 >= 0 && student[i - 1] == 1) {
                    student[i]++;
                    student[i - 1]--;
                } else if (i + 1 < student.length && student[i + 1] == 1) {
                    student[i]++;
                    student[i + 1]--;
                } else {
                    answer--;
                }
            }
        }

        return answer;
    }
}