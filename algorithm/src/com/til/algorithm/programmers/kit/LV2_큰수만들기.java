package com.til.algorithm.programmers.kit;

public class LV2_큰수만들기 {

    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        int nxt = 0;
        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;
            for (int j = idx; j <= i + k; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    nxt = j;
                }
            }
            answer.append(max);
            idx = nxt + 1;
        }
        return answer.toString();
    }
}