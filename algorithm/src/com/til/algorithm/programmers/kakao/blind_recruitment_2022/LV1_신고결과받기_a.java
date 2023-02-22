package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LV1_신고결과받기_a {

    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String row : report) {
            String[] rowSplit = row.split(" ");
            String reporter = rowSplit[0];
            String target = rowSplit[1];
            if (!map.containsKey(target)) {
                map.put(target, new ArrayList<>());
            }
            if (map.get(target).contains(reporter)) {
                continue;
            }
            map.get(target).add(reporter);
        }
        LinkedHashMap<String, Integer> mailMap = new LinkedHashMap<>();
        for (String id : id_list) {
            mailMap.put(id, 0);
        }
        map.forEach((key, value) -> {
            if (value.size() >= k) {
                for (String reporter : value) {
                    mailMap.put(reporter, mailMap.get(reporter) + 1);
                }
            }
        });
        ArrayList<Integer> answer = new ArrayList<>(mailMap.values());
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}