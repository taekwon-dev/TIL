package com.til.algorithm.leetCode.sliding_window;

public class LEET_1876 {

    public int countGoodSubstrings(String s) {
        int answer = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            String candidate = s.substring(i, i + 3);
            if (candidate.charAt(0) != candidate.charAt(1) && candidate.charAt(0) != candidate.charAt(2) && candidate.charAt(1) != candidate.charAt(2)) {
                answer++;
            }
        }
        return answer;
    }
}