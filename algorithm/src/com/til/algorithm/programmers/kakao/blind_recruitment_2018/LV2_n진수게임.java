package com.til.algorithm.programmers.kakao.blind_recruitment_2018;

public class LV2_n진수게임 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int num = 0;
        while (sb.length() < m * t) {
            sb.append(Integer.toString(num++, n));
        }

        for (int i = p - 1; i < m * t; i+=m) {
            answer.append(sb.charAt(i));
        }
        return answer.toString().toUpperCase();
    }
}
