package com.til.algorithm.programmers.kakao.blind_recruitment_2021;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class LV2_메뉴리뉴얼 {

    private Map<String, Integer> menu = new HashMap<>();
    private List<String> result = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        for (int c : course) {
            for (String order : orders) {
                char[] food = order.toCharArray();
                Arrays.sort(food);
                backtracking(food, c, 0, 0, "");
            }
            if (menu.size() == 0) {
                continue;
            }
            int maxOrderedCount = Collections.max(menu.values());
            for (String key : menu.keySet()) {
                if (maxOrderedCount >= 2 && menu.get(key) == maxOrderedCount) {
                    result.add(key);
                }
            }
            menu.clear();
        }
        Collections.sort(result);
        System.out.println("result = " + result);
        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    private void backtracking(char[] food, int course, int depth, int start, String s) {
        if (depth == course) {
            menu.put(s, menu.getOrDefault(s, 0) + 1);
            return;
        }
        for (int i = start; i < food.length; i++) {
            backtracking(food, course, depth + 1, i + 1, s + food[i]);
        }
    }
}
