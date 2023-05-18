package com.til.algorithm.leetCode.string;

import java.util.Stack;

public class LEET_1047 {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder answer = new StringBuilder();
        for (char c : stack) {
            answer.append(c);
        }
        return answer.toString();
    }
}