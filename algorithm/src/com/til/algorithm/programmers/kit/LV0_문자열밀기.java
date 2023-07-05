package com.til.algorithm.programmers.kit;

public class LV0_문자열밀기 {

    public int solution(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }

        int answer = -1;

        for (int i = 0; i < A.length() - 1; i++) {
            char target = A.charAt(A.length() - 1);
            A = A.substring(0, A.length() - 1);
            A = target + A;

            if (A.equals(B)) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }
}