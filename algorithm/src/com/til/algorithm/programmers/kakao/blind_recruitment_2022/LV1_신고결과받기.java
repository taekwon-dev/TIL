package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;

class LV1_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> resultMap = new HashMap<>();
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();

        for (String id : id_list) {
            resultMap.put(id, 0);
            reportMap.put(id, new HashSet<>());
        }

        for (String r : report) {
            String[] tmp = r.split(" ");
            String from = tmp[0];
            String to = tmp[1];

            reportMap.get(to).add(from);
        }

        for (String key : reportMap.keySet()) {
            if (reportMap.get(key).size() >= k) {
                for (String receiver : reportMap.get(key)) {
                    int cnt = resultMap.get(receiver) + 1;
                    resultMap.put(receiver, cnt);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = resultMap.get(id_list[i]);
        }
        return answer;
    }
}