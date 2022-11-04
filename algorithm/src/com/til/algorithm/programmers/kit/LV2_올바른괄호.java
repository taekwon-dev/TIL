package com.til.algorithm.programmers.kit;

import java.util.Stack;

public class LV2_올바른괄호 {
    boolean solution(String s) {
        if (s.startsWith(")")) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
