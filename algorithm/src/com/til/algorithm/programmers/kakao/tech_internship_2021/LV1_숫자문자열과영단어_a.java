package com.til.algorithm.programmers.kakao.tech_internship_2021;

import java.util.HashMap;
import java.util.Map;

public class LV1_숫자문자열과영단어_a {

    public int solution(String s) {
        Map<String, Integer> dictionary = new HashMap<>(){{
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

        for (String word : dictionary.keySet()) {
            if (s.contains(word)) {
                s = s.replace(word, String.valueOf(dictionary.get(word)));
            }
        }
        return Integer.parseInt(s);
    }
}