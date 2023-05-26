package com.til.algorithm.leetCode.string;

public class LEET_1221 {

    public int balancedStringSplit(String s) {
        int answer = 0;
        int l = 0;
        int r = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                answer++;
            }
        }
        return answer;
    }
}