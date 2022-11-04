package com.til.algorithm.programmers.kakao.blind_recruitment_2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LV1_실패율 {
    public int[] solution(int N, int[] stages) {
        List<double[]> list = new ArrayList<>();
        int p = stages.length;
        for (int i = 1; i <= N; i++) {
            if (p == 0) {
                list.add(new double[]{i, 0});
                continue;
            }
            int each = 0;
            for (int stage : stages) {
                if (i == stage) {
                    each++;
                }
            }
            list.add(new double[]{i, (double) each / (double) p});
            p -= each;
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1[1] > o2[1]) {
                return -1;
            } else if (o1[1] == o2[1]) {
                return Double.valueOf(o1[0]).compareTo(Double.valueOf(o2[0]));
            }
            return 1;
        });
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) list.get(i)[0];
        }
        return answer;
    }
}
