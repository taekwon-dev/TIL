package com.til.algorithm.programmers.kakao.blind_recruitment_2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class LV2_메뉴리뉴얼 {

    private HashMap<String, Integer> menu = new HashMap<>();
    private ArrayList<String> candidate = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < course.length; i++) {
            for (String order : orders) {
                char[] combi = order.toCharArray();
                Arrays.sort(combi);
                backtracking(0, 0, combi, course[i], "");
            }
            if (!menu.isEmpty()) {
                ArrayList<Integer> orderCount = new ArrayList<>(menu.values());
                int max = Collections.max(orderCount);
                if (max > 1) {
                    menu.forEach((k, v) -> {
                        if (v == max) {
                            candidate.add(k);
                        }
                    });
                }
            }
            menu.clear();
        }
        Collections.sort(candidate);
        String[] answer = candidate.toArray(new String[0]);
        return answer;
    }

    private void backtracking(int depth, int start, char[] combi, int courseNum, String s) {
        if (depth == courseNum) {
            menu.put(s, menu.getOrDefault(s, 0) + 1);
            return;
        }
        for (int i = start; i < combi.length; i++) {
            backtracking(depth + 1, i + 1, combi, courseNum, s + combi[i]);
        }
    }
}