package com.til.algorithm.programmers.kit;

import java.util.Arrays;

public class LV1_가장가까운글자 {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alphabet = new int[26];

        Arrays.fill(alphabet, -1);

        for (int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i) - 'a'] == -1) {
                answer[i] = -1;
                alphabet[s.charAt(i) - 'a'] = i;
                continue;
            }
            answer[i] = i - alphabet[s.charAt(i) - 'a'];
            alphabet[s.charAt(i) - 'a'] = i;
        }
        return answer;
    }
}