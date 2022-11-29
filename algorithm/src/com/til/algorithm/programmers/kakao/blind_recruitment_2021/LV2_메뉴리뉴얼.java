package com.til.algorithm.programmers.kakao.blind_recruitment_2021;

import java.util.*;

public class LV2_메뉴리뉴얼 {

    private List<String> result = new ArrayList<>();
    private Map<String, Integer> map;
    private char[] menu;

    public String[] solution(String[] orders, int[] course) {
        for (int courseLength : course) {
            map = new HashMap<>();
            for (String order : orders) {
                if (order.length() < courseLength) {
                    continue;
                }
                menu = order.toCharArray();
                Arrays.sort(menu);
                backtracking(courseLength, 0, 0, "");
            }
            if (map.size() == 0) {
                continue;
            }
            int maxOrderedCount = Collections.max(map.values());
            Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, Integer> entry = iter.next();
                if (maxOrderedCount >= 2 && entry.getValue() == maxOrderedCount) {
                    result.add(entry.getKey());
                }
            }
        }
        Collections.sort(result);
        String[] answer = new String[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    private void backtracking(int courseLength, int depth, int index, String combination) {
        if (depth == courseLength) {
            map.put(combination, map.getOrDefault(combination, 0) + 1);
            return;
        }
        for (int i = index; i < menu.length; i++) {
            backtracking(courseLength, depth + 1, i + 1, combination + menu[i]);
        }
    }
}
