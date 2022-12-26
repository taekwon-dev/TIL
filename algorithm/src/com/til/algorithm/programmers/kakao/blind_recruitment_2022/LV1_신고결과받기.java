package com.til.algorithm.programmers.kakao.blind_recruitment_2022;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

class LV1_신고결과받기 {

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> mailCount = new HashMap<>();
        Map<String, Set<String>> reportLog = new HashMap<>();

        for (String id : id_list) {
            mailCount.put(id, 0);
            reportLog.put(id, new HashSet<>());
        }

        for (String r : report) {
            String[] tmp = r.split(" ");
            String from = tmp[0];
            String to = tmp[1];
            // 신고 당한 사람 = {신고한 사람 ... }
            reportLog.get(to).add(from);
        }

        for (String target : reportLog.keySet()) {
            if (reportLog.get(target).size() >= k) {
                for (String mailReceiver : reportLog.get(target)) {
                    mailCount.put(mailReceiver, mailCount.get(mailReceiver) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailCount.get(id_list[i]);
        }
        return answer;
    }
}