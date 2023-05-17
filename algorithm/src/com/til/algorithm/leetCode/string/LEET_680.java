package com.til.algorithm.leetCode.string;

public class LEET_680 {

    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrom(s, l + 1, r) || isPalindrom(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrom(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}