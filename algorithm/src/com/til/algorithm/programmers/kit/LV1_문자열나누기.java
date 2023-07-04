package com.til.algorithm.programmers.kit;

public class LV1_문자열나누기 {

    private static final int X = 0;

    private int answer = 0;

    public int solution(String s) {
        recursion(s);
        return answer;
    }

    private void recursion(String s) {
        int x = 1;
        int y = 0;

        if (s.length() == 0) {
            return;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(X)) {
                x++;
                continue;
            }
            y++;

            if (x == y) {
                answer++;
                recursion(s.substring(i + 1));
                return;
            }
        }
        answer++;
    }
}