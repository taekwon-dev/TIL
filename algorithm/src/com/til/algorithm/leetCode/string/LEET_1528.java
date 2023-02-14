package com.til.algorithm.leetCode.string;

public class LEET_1528 {

    public String restoreString(String s, int[] indices) {
        char[] c = new char[s.length()];
        for (int i = 0; i < c.length; i++) {
            c[indices[i]] = s.charAt(i);
        }
        return String.valueOf(c);
    }
}
