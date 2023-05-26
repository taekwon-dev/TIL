package com.til.algorithm.leetCode.top100_liked;

import java.util.HashMap;

public class LEET_13 {

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                answer += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            } else {
                answer += map.get(s.charAt(i));
            }
        }
        return answer;
    }
}