package com.til.algorithm.programmers.kit;

public class LV1_이상한문자만들기 {

    public String solution(String s) {
        String[] words = s.split(" ", -1);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (j % 2 == 0) {
                    answer.append(Character.toUpperCase(words[i].charAt(j)));
                    continue;
                }
                answer.append(Character.toLowerCase(words[i].charAt(j)));
            }
            if (i < words.length - 1) {
                answer.append(' ');
            }
        }
        return answer.toString();
    }
}