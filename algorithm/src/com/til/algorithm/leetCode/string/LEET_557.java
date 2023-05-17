package com.til.algorithm.leetCode.string;

public class LEET_557 {

    public String reverseWords(String s) {
        StringBuilder answer = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            answer.append(sb.reverse() + " ");
        }
        return answer.toString().trim();
    }
}