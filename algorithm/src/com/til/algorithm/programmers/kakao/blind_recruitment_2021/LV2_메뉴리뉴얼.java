package com.til.algorithm.programmers.kakao.blind_recruitment_2021;

import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class LV2_메뉴리뉴얼 {

    private HashMap<String, Integer> candidates = new HashMap<>();
    private char[] menu;
    private int courseNum;

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            courseNum = course[i];
            for (String order : orders) {
                menu = order.toCharArray();
                Arrays.sort(menu);
                backtracking(0, 0, "");
            }
            int max = Collections.max(candidates.values());
            if (max < 2) {
                continue;
            }
            candidates.forEach((k, v) -> {
                if (v == max) {
                    answer.add(k);
                }
            });
            candidates.clear();
        }
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }

    private void backtracking(int depth, int start, String candidate) {
        if (depth == courseNum) {
            candidates.put(candidate, candidates.getOrDefault(candidate, 0) + 1);
            return;
        }
        for (int i = start; i < menu.length; i++) {
            backtracking(depth + 1, i + 1, candidate + menu[i]);
        }
    }
}