package com.til.algorithm.leetCode.string;

import java.util.Stack;

public class LEET_20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                if (c == ')' || c == '}' || c == ']') {
                    return false;
                }
                stack.push(c);
                continue;
            }
            if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else {
                stack.push(c);
            }

        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}