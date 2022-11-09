package com.til.algorithm.programmers.kakao.blind_recruitment_2019;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LV2_오픈채팅방 {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> visitLog = new ArrayList<>();
        for (String log : record) {
            StringTokenizer st = new StringTokenizer(log);
            String tag = st.nextToken();
            String uid = st.nextToken();
            String nickname = null;

            if (!tag.equals("Leave")) {
                nickname = st.nextToken();
            }

            switch (tag) {
                case "Enter":
                    map.put(uid, nickname);
                    visitLog.add(uid + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    visitLog.add(uid + "님이 나갔습니다.");
                    break;
                case "Change":
                    map.put(uid, nickname);
                    break;
            }
        }
        String[] answer = new String[visitLog.size()];
        int idx = 0;
        for (String log : visitLog) {
            int endOfNicknameIdx = log.indexOf("님");
            String uid = log.substring(0, endOfNicknameIdx);
            answer[idx++] = log.replace(uid, map.get(uid));
        }
        return answer;
    }
}
