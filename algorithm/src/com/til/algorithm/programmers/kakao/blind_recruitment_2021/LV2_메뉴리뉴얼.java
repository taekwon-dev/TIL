package com.til.algorithm.programmers.kakao.blind_recruitment_2021;

import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class LV2_메뉴리뉴얼 {

    private HashMap<String, Integer> menu = new HashMap<>();
    private char[] orderedMenu;
    private int courseNum;

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            courseNum = course[i];
            for (String order : orders) {
                orderedMenu = order.toCharArray();
                Arrays.sort(orderedMenu);
                backtracking(0, 0, "");
            }
            int max = Collections.max(menu.values());
            if (max < 2) {
                continue;
            }
            menu.forEach((k, v) -> {
                if (v == max) {
                    answer.add(k);
                }
            });
            menu.clear();
        }
        Collections.sort(answer);
        /**
         *  List<String> to String[]
         */
        return answer.toArray(new String[0]);
    }

    /**
     *   백트랙킹 + 조합
     */
    private void backtracking(int depth, int index, String combination) {
        if (depth == courseNum) {
            menu.put(combination, menu.getOrDefault(combination, 0) + 1);
            return;
        }
        for (int i = index; i < orderedMenu.length; i++) {
            backtracking(depth + 1, i + 1, combination + orderedMenu[i]);
        }
    }
}