package com.til.algorithm.programmers.kakao.blind_recruitment_2021;

import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class LV2_메뉴리뉴얼 {

    private ArrayList<String> result = new ArrayList<>();
    private HashMap<String, Integer> menu = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for (int courseNum : course) {
            for (int i = 0; i < orders.length; i++) {
                char[] order = orders[i].toCharArray();
                Arrays.sort(order);
                backtracking(order, courseNum, 0, 0, "");
            }
            int maxOrderCount = Collections.max(menu.values());
            if (maxOrderCount < 2) {
                continue;
            }
            menu.forEach((k, v) -> {
                if (v == maxOrderCount) {
                    result.add(k);
                }
            });
            menu.clear();
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private void backtracking(char[] order, int courseNum, int depth, int index, String candidate) {
        if (depth == courseNum) {
            menu.put(candidate, menu.getOrDefault(candidate, 0) + 1);
            return;
        }
        for (int i = index; i < order.length; i++) {
            backtracking(order, courseNum, depth + 1, i + 1, candidate + order[i]);
        }
    }
}