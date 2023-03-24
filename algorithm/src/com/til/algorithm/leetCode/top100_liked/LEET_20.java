package com.til.algorithm.leetCode.top100_liked;

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
            if (stack.peek() == '(' && c == ')') {
                stack.pop();
            } else if (stack.peek() == '{' && c == '}') {
                stack.pop();
            } else if (stack.peek() == '[' && c == ']') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
