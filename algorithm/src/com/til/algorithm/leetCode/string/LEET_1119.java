package com.til.algorithm.leetCode.string;

import java.util.HashSet;

public class LEET_1119 {

    public String removeVowels(String s) {
        StringBuilder answer = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                continue;
            }
            answer.append(s.charAt(i));
        }
        return answer.toString();
    }
}