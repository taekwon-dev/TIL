package com.til.algorithm.programmers.kit;

public class LV1_핸드폰번호가리기 {
    public String solution(String phone_number) {
        String answer = "";
        for (int i = 0; i < phone_number.length(); i++) {
            if (i < phone_number.length() - 4) {
                answer += "*";
                continue;
            }
            answer += phone_number.charAt(i);
        }
        return answer;
    }
}
