package com.til.algorithm.programmers.kakao.tech_internship_2021;

import java.util.HashMap;

public class LV1_숫자문자열과영단어 {
    public int solution(String s) {
        HashMap<String, Integer> map = new HashMap<>(){{
            put("zero", 0);
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
        }};

        for (String key : map.keySet()) {
            if (s.contains(key)) {
                s = s.replace(key, String.valueOf(map.get(key)));
            }
        }
        return Integer.valueOf(s);
    }
}
