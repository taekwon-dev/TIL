package com.til.algorithm.programmers.kit.novice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LV0_등수매기기 {
    public int[] solution(int[][] score) {
        List<Double> avg = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            double eng = score[i][0];
            double math = score[i][1];
            avg.add((eng + math) / 2);
        }

        List<Double> avg_sorted = new ArrayList<>(avg);
        Collections.sort(avg_sorted, Collections.reverseOrder());

        int[] answer = new int[score.length];
        for (int i = 0; i < avg.size(); i++) {
            answer[i] = avg_sorted.indexOf(avg.get(i)) + 1;
        }
        return answer;
    }
}
