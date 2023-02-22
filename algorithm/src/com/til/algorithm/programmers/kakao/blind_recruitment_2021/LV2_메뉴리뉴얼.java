package com.til.algorithm.programmers.kakao.blind_recruitment_2021;

import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class LV2_메뉴리뉴얼 {

    private HashMap<String, Integer> table = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        for (int menuSize : course) {
            for (String order : orders) {
                char[] menu = order.toCharArray();
                Arrays.sort(menu);
                backtracking(menuSize, menu, 0, 0, "");
            }
            ArrayList<Integer> count = new ArrayList<>(table.values());
            int max = Collections.max(count);
            if (max < 2) {
                continue;
            }
            table.forEach((k, v) -> {
                if (v == max) {
                    answer.add(k);
                }
            });
            table.clear();
        }
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }

    private void backtracking(int menuSize, char[] menu, int depth, int index, String combination) {
        if (depth == menuSize) {
            table.put(combination, table.getOrDefault(combination, 0) + 1);
            return;
        }
        for (int i = index; i < menu.length; i++) {
            backtracking(menuSize, menu, depth + 1, i + 1, combination + menu[i]);
        }
    }
}