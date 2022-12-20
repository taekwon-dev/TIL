package com.til.algorithm.programmers.kit.novice;

public class LV0_문자열밀기 {

    public int solution(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }
        int answer = 0;
        String s = A;
        for (int i = 0; i < A.length() - 1; i++) {
            s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
            answer++;
            if (s.equals(B)) {
                return answer;
            }
        }
        return -1;
    }
}
