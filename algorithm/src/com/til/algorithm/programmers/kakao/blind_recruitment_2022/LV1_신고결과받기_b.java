package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

import java.util.HashMap;
import java.util.HashSet;

public class LV1_신고결과받기_b {

    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> mail = new HashMap<>();

        for (int idx = 0; idx < id_list.length; idx++) {
            String id = id_list[idx];
            map.put(id, new HashSet<>());
            mail.put(id, idx);
        }

        for (String r : report) {
            String[] reportSplit = r.split(" ");
            String reporter = reportSplit[0];
            String target = reportSplit[1];
            map.get(target).add(reporter);
        }
        int[] answer = new int[id_list.length];
        for (int i = 0; i < answer.length; i++) {
            HashSet<String> set = map.get(id_list[i]);
            if (set.size() >= k) {
                for (String receiver : set) {
                    answer[mail.get(receiver)]++;
                }
            }
        }
        return answer;
    }
}