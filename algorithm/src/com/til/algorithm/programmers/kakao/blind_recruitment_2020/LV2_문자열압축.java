package com.til.algorithm.programmers.kakao.blind_recruitment_2020;

public class LV2_문자열압축 {

    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            int prefix = 1;
            String curr = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            for (int j = i; j <= s.length(); j += i) {
                String next;
                if (j + i > s.length()) {
                    next = s.substring(j);
                } else {
                    next = s.substring(j, j + i);
                }
                if (curr.equals(next)) {
                    prefix++;
                } else {
                    sb.append((prefix != 1 ? prefix : "") + curr);
                    curr = next;
                    prefix = 1;
                }
            }
            sb.append(curr);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}