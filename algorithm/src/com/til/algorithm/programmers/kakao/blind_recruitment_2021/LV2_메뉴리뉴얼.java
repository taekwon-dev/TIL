package com.til.algorithm.programmers.kakao.blind_recruitment_2021;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class LV2_메뉴리뉴얼 {
    Map<String, Integer> map = new HashMap<>();
    List<String> answerList = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        for (int len : course) {
            for (String order : orders) {
                char[] c = order.toCharArray();
                Arrays.sort(c);
                backtracking(len, c, 0, 0, "");
            }
            if (!map.isEmpty()) {
                List<Integer> list = new ArrayList<>(map.values());
                int max = Collections.max(list);
                if (max > 1) {
                    for (String key : map.keySet()) {
                        if (map.get(key) == max) {
                            answerList.add(key);
                        }
                    }
                }
                map.clear();
            }
        }
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    private void backtracking(int len, char[] c, int depth, int start, String s) {
        if (depth == len) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            return;
        }
        for (int i = start; i < c.length; i++) {
            backtracking(len, c, depth + 1, i + 1, s + c[i]);
        }
    }
}
