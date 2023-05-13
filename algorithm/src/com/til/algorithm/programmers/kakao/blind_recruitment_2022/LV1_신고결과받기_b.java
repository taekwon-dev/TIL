package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

import java.util.HashMap;
import java.util.HashSet;

public class LV1_신고결과받기_b {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, Integer> idMap = new HashMap<>();
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            idMap.put(id_list[i], i);
            reportMap.put(id_list[i], new HashSet<>());
        }

        for (String r : report) {
            String[] fromTo = r.split(" ");
            String from = fromTo[0];
            String to = fromTo[1];

            reportMap.get(to).add(from);
        }

        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> reportSet = reportMap.get(id_list[i]);
            if (reportSet.size() >= k) {
                for (String reporter : reportSet) {
                    answer[idMap.get(reporter)]++;
                }
            }
        }
        return answer;
    }
}