package com.til.algorithm.programmers.kakao.tech_internship_2021;

import java.util.HashMap;
import java.util.Map;

public class LV1_숫자문자열과영단어_b {


    private HashMap<String, Integer> map = new HashMap<>(){{
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

    public int solution(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                result.append(c);
                continue;
            }
            sb.append(c);
            String temp = sb.toString();
            if (map.containsKey(temp)) {
                result.append(map.get(temp));
                sb.delete(0, sb.length());
            }
        }
        int answer = Integer.parseInt(result.toString());
        return answer;
    }
}