package com.til.algorithm.programmers.kakao.tech_internship_2022;

import java.util.HashMap;
import java.util.Map;

public class LV1_성격유형검사하기_b {

    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> score = new HashMap<>(){{
            put('R', 0);
            put('T', 0);
            put('C', 0);
            put('F', 0);
            put('J', 0);
            put('M', 0);
            put('A', 0);
            put('N', 0);
        }};
        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);

            if (choices[i] == 1) {
                score.put(disagree, score.get(disagree) + 3);
                continue;
            }
            if (choices[i] == 2) {
                score.put(disagree, score.get(disagree) + 2);
                continue;
            }
            if (choices[i] == 3) {
                score.put(disagree, score.get(disagree) + 1);
                continue;
            }
            if (choices[i] == 5) {
                score.put(agree, score.get(agree) + 1);
                continue;
            }
            if (choices[i] == 6) {
                score.put(agree, score.get(agree) + 2);
                continue;
            }
            if (choices[i] == 7) {
                score.put(agree, score.get(agree) + 3);
                continue;
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(compare(score, 'R', 'T'));
        sb.append(compare(score, 'C', 'F'));
        sb.append(compare(score, 'J', 'M'));
        sb.append(compare(score, 'A', 'N'));
        return sb.toString();
    }

    private char compare(Map<Character, Integer> score, char a, char b) {
        if (score.get(a) >= score.get(b)) {
            return a;
        }
        return b;
    }
}