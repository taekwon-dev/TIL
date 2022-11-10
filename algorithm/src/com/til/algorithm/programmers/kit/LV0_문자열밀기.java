package com.til.algorithm.programmers.kit;

public class LV0_문자열밀기 {
    public int solution(String A, String B) {
        int answer = 0;
        if (A.equals(B)) {
            return answer;
        }
        for (int i = 0; i < A.length() - 1; i++) {
            answer++;
            String former = A.substring(0, A.length() - 1);
            String latter = A.substring(A.length() - 1);
            A = latter + former;
            if (A.equals(B)) {
                return answer;
            }
        }
        return -1;
    }
}
