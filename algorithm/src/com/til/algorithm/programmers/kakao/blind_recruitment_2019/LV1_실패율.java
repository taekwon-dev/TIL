package com.til.algorithm.programmers.kakao.blind_recruitment_2019;

import java.util.ArrayList;
import java.util.Collections;

public class LV1_실패율 {

    public int[] solution(int N, int[] stages) {
        ArrayList<double[]> rate = new ArrayList<>();
        int len = stages.length;
        for (int idx = 1; idx <= N; idx++) {
            if (len == 0) {
                rate.add(new double[]{idx, 0});
                continue;
            }
            int failure = 0;
            for (int stage : stages) {
                if (idx == stage) {
                    failure++;
                }
            }
            rate.add(new double[]{idx, failure / (double) len});
            len -= failure;
        }
        // 양수 값 리턴 : 교환 X
        // 음수 값 리턴 : 교환 O
        Collections.sort(rate, (r1, r2) -> {
            if (r1[1] > r2[1]) {
                // 이전 값이 다음 값보다 실패율이 크면, 교환해서 내림차순으로 정렬
                return -1;
            } else if (r1[1] == r2[1]) {
                // Auto Boxing (double to Double)
                return Double.valueOf(r1[0]).compareTo(r2[0]);
            }
            return 1;
        });
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            // double to int (강제 형변환 적용)
            answer[i] = (int) rate.get(i)[0];
        }
        return answer;
    }
}