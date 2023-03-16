package com.til.algorithm.leetCode.string;

import java.util.Stack;

/**
 *  Stack 자료구조 활용
 */
public class LEET_1047_b {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] word = s.toCharArray();

        for (char c : word) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek() != c) {
                stack.push(c);
                continue;
            }
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}