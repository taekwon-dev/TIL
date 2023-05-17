package com.til.algorithm.leetCode.string;

public class LEET_1844 {

    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(c);
                continue;
            }
            char target = sb.charAt(sb.length() - 1);
            int digit = c - '0';
            sb.append(shift(target, digit));
        }
        return sb.toString();
    }

    private char shift(char c, int digit) {
        return (char) (c + digit);
    }
}