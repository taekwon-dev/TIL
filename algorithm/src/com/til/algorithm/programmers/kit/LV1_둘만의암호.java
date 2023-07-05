package com.til.algorithm.programmers.kit;

import java.util.HashSet;

public class LV1_둘만의암호 {

    public String solution(String s, String skip, int index) {
        HashSet<Character> skipChar = new HashSet<>();

        for (char c : skip.toCharArray()) {
            skipChar.add(c);
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < index; j++) {
                c++;
                if (c > 'z') {
                    c -= 26;
                }
                if (skipChar.contains(c)) {
                    j--;
                }
            }
            answer.append(c);
        }
        return answer.toString();
    }
}