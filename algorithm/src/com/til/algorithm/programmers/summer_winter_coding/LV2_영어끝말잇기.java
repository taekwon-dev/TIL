package com.til.algorithm.programmers.summer_winter_coding;

import java.util.ArrayList;
import java.util.List;

public class LV2_영어끝말잇기 {

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> history = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (history.size() == 0) {
                history.add(words[i]);
                continue;
            }
            String last = history.get(history.size() - 1);
            if (last.charAt(last.length() - 1) != words[i].charAt(0)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            if (history.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            history.add(words[i]);
        }
        return answer;
    }
}