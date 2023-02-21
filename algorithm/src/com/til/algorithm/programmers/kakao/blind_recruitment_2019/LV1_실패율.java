package com.til.algorithm.programmers.kakao.blind_recruitment_2019;

import java.util.ArrayList;
import java.util.Collections;

public class LV1_실패율 {

    public int[] solution(int N, int[] stages) {
        ArrayList<double[]> rate = new ArrayList<>();
        int len = stages.length;
        for (int i = 1; i <= N; i++) {
            if (len == 0) {
                rate.add(new double[]{i, 0});
                continue;
            }
            int count = 0;
            for (int stage : stages) {
                if (i == stage) {
                    count++;
                }
            }
            rate.add(new double[]{i, (double) count / len});
            len -= count;
        }
        Collections.sort(rate, (r1, r2) -> {
            if (r1[1] > r2[1]) {
                return -1;
            }
            else if (r1[1] == r2[1]) {
                return Double.valueOf(r1[0]).compareTo(r2[0]);
            }
            return 1;
        });
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) rate.get(i)[0];
        }
        return answer;
    }
}