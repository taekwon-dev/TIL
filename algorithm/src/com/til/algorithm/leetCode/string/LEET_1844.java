package com.til.algorithm.leetCode.string;

public class LEET_1844 {
    public String replaceDigits(String s) {
        char[] a = s.toCharArray();

        for (int i = 1; i < a.length; i += 2) {
            a[i] = (char) (a[i - 1] - '0');
        }
        return String.valueOf(a);
    }
}