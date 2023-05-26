package com.til.algorithm.leetCode.string;

public class LEET_2114 {

    public int mostWordsFound(String[] sentences) {
        int word = 0;
        for (String sentence : sentences) {
            String[] s = sentence.split(" ");
            if (word < s.length) {
                word = s.length;
            }
        }
        return word;
    }
}