package com.til.algorithm.leetCode.string;

import java.util.Stack;

public class LEET_151 {

    public String reverseWords(String s) {
        s = s.trim().replaceAll(" +", " ");
        String[] words = s.split(" ");

        Stack<String> stack = new Stack<>();
        for (String word : words) {
            stack.push(word);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        String result = sb.toString();
        return result.substring(0, result.length() - 1);
    }
}
