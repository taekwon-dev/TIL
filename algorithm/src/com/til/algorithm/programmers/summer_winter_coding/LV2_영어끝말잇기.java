package com.til.algorithm.programmers.summer_winter_coding;

import java.util.ArrayList;

public class LV2_영어끝말잇기 {

    private ArrayList<String> list = new ArrayList<>();

    public int[] solution(int n, String[] words) {
        int index = -1;
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                list.add(words[i]);
                continue;
            }
            if (list.contains(words[i])) {
                index = i;
                break;
            }
            String prev = list.get(list.size() - 1);
            if (prev.charAt(prev.length() - 1) != words[i].charAt(0)) {
                index = i;
                break;
            }
            list.add(words[i]);
        }
        int[] answer = new int[2];
        if (index == -1) {
            return answer;
        }
        answer[0] = index % n + 1;
        answer[1] = index / n + 1;
        return answer;
    }
}