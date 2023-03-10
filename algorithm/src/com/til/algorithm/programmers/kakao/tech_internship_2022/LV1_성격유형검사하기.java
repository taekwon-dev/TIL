package com.til.algorithm.programmers.kakao.tech_internship_2022;

import java.util.HashMap;
import java.lang.StringBuilder;

public class LV1_성격유형검사하기 {

    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> map = new HashMap<>();

        /**
         *  문제에서 고정된 조건이 있는 경우, 아래와 같이 활용하기!
         */
        char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};

        for (char[] type : types) {
            map.put(type[0], 0);
            map.put(type[1], 0);
        }

        for (int idx = 0; idx < survey.length; idx++) {
            char disagree = survey[idx].charAt(0);
            char agree = survey[idx].charAt(1);
            int val = choices[idx];
            if (val == 1) {
                map.put(disagree, map.get(disagree) + 3);
            } else if (val == 2) {
                map.put(disagree, map.get(disagree) + 2);
            } else if (val == 3) {
                map.put(disagree, map.get(disagree) + 1);
            } else if (val == 4) {
                // nothing happen
            } else if (val == 5) {
                map.put(agree, map.get(agree) + 1);
            } else if (val == 6) {
                map.put(agree, map.get(agree) + 2);
            } else if (val == 7) {
                map.put(agree, map.get(agree) + 3);
            }
        }

        StringBuilder answer = new StringBuilder();
        for (char[] type : types) {
            if (map.get(type[0]) >= map.get(type[1])) {
                answer.append(type[0]);
                continue;
            }
            answer.append(type[1]);
        }
        return answer.toString();
    }
}