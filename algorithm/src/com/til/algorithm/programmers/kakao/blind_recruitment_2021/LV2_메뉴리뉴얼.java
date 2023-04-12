package com.til.algorithm.programmers.kakao.blind_recruitment_2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class LV2_메뉴리뉴얼 {

    private HashMap<String, Integer> menuMap = new HashMap<>();
    private ArrayList<String> result = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < course.length; i++) {
            for (String order : orders) {
                char[] menu = order.toCharArray();
                Arrays.sort(menu);
                backtracking(menu, course[i], 0, 0, "");
            }
            if (!menuMap.isEmpty()) {
                ArrayList<Integer> orderCount = new ArrayList<>(menuMap.values());
                int max = Collections.max(orderCount);
                if (max > 1) {
                    for (String key : menuMap.keySet()) {
                        if (menuMap.get(key) == max) {
                            result.add(key);
                        }
                    }
                }
                menuMap.clear();
            }
        }
        Collections.sort(result);
        String[] answer = new String[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    private void backtracking(char[] menu, int courseNum, int depth, int index, String combi) {
        if (depth == courseNum) {
            menuMap.put(combi, menuMap.getOrDefault(combi, 0) + 1);
            return;
        }
        for (int i = index; i < menu.length; i++) {
            backtracking(menu, courseNum, depth + 1, i + 1, combi + menu[i]);
        }
    }
}