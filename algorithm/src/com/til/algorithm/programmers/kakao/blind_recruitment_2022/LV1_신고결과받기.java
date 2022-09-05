package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;

/**
 *  Map (HashMap)
 *  Set (HashSet)
 */
class LV1_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            map.put(name, new HashSet<>());
            idxMap.put(name, i);
        }

        for (String s : report) {
            String[] str = s.split(" ");
            String from = str[0];
            String to = str[1];
            map.get(to).add(from);
        }

        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> reporter = map.get(id_list[i]);
            if (reporter.size() >= k) {
                for (String name : reporter) {
                    answer[idxMap.get(name)]++;
                }
            }
        }

        return answer;
    }
}