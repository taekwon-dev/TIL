package com.til.algorithm.programmers.kakao.blind_recruitment_2019;

import java.util.HashMap;
import java.util.ArrayList;

public class LV2_오픈채팅방 {

    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> uids = new ArrayList<>();
        ArrayList<String> notifications = new ArrayList<>();

        for (String r : record) {
            String[] rSplit = r.split(" ");
            String flag = rSplit[0];
            String uid = rSplit[1];

            if (flag.equals("Change")) {
                if (map.containsKey(uid)) {
                    map.put(uid, rSplit[2]);
                }
                continue;
            }
            if (flag.equals("Enter")) {
                map.put(uid, rSplit[2]);
                uids.add(uid);
                notifications.add("님이 들어왔습니다.");
                continue;
            }
            uids.add(uid);
            notifications.add("님이 나갔습니다.");
        }
        String[] answer = new String[uids.size()];
        for (int i = 0; i < uids.size(); i++) {
            String nickname = map.get(uids.get(i));
            answer[i] = nickname + notifications.get(i);
        }
        return answer;
    }
}