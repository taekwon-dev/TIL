package com.til.algorithm.leetCode.string;

public class LEET_125 {

    public boolean isPalindrome(String s) {
        if (s.isBlank()) {
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();

        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
                continue;
            }
            return false;
        }
        return true;
    }
}