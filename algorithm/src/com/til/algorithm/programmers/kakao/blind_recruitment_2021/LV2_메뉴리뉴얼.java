package com.til.algorithm.programmers.kakao.blind_recruitment_2021;

import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class LV2_메뉴리뉴얼 {

    private HashMap<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        for (int len : course) {
            for (String order : orders) {
                if (order.length() < len) {
                    continue;
                }
                char[] menu = order.toCharArray();
                Arrays.sort(menu);
                backtracking(menu, len, 0, 0, "");
            }
            if (map.isEmpty()) {
                continue;
            }
            ArrayList<Integer> menuSizes = new ArrayList<>(map.values());
            int max = Collections.max(menuSizes);
            if (max < 2) {
                continue;
            }
            map.forEach((k, v) -> {
                if (v == max) {
                    answer.add(k);
                }
            });
            map.clear();
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    private void backtracking(char[] menu, int len, int depth, int idx, String result) {
        if (depth == len) {
            map.put(result, map.getOrDefault(result, 0) + 1);
            return;
        }
        for (int i = idx; i < menu.length; i++) {
            backtracking(menu, len, depth + 1, i + 1, result + menu[i]);
        }
    }
}