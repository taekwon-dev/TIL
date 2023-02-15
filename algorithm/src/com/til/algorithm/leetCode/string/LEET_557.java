package com.til.algorithm.leetCode.string;

public class LEET_557 {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(reverse(word.toCharArray())).append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    private String reverse(char[] c) {
        int i = 0;
        int j = c.length - 1;
        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(c);
    }
}