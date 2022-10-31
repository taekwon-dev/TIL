package com.til.algorithm.programmers.kakao.blind_recruitment_2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LV2_압축 {
    Map<String, Integer> map = new HashMap<>();
    List<Integer> answerList = new ArrayList<>();

    public int[] solution(String msg) {
        initDict();

        String w = "";
        String c = "";
        int idx = 0;

        for (int i = 0; i < msg.length(); i++) {
            w += msg.charAt(i);
            idx = map.get(w);
            if (i + 1 < msg.length()) {
                c = "" + msg.charAt(i + 1);
                String wc = w + c;
                if (map.containsKey(wc)) {
                    continue;
                }
                w = wc;
            }
            answerList.add(idx);
            map.put(w, map.size() + 1);
            w = "";
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    private void initDict() {
        int idx = 1;
        for (int i = 'A'; i <= 'Z'; i++) {
            map.put(Character.toString((char) i), idx++);
        }
    }
}
