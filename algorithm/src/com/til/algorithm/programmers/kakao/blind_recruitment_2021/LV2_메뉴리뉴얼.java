package com.til.algorithm.programmers.kakao.blind_recruitment_2021;

import java.util.*;

public class LV2_메뉴리뉴얼 {
    Map<String, Integer> map = new HashMap<>();
    List<String> list = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    public String[] solution(String[] orders, int[] course) {
        for (int c : course) {
            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                order = new String(chars);
                backtracking(c, order, 0, 0, "");
            }
            for (String menu : map.keySet()) {
                if (max >= 2 && map.get(menu) == max) {
                    list.add(menu);
                }
            }
            max = Integer.MIN_VALUE;
            map.clear();
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private void backtracking(int c, String order, int depth, int start, String s) {
        if (depth == c) {
            int count = map.getOrDefault(s, 0) + 1;
            map.put(s, count);
            max = Math.max(max, count);
            return;
        }
        for (int i = start; i < order.length(); i++) {
            backtracking(c, order, depth + 1, i + 1, s + order.charAt(i));
        }
    }
}
