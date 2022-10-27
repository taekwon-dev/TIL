package com.til.algorithm.leetCode.string;


import java.util.Stack;

public class LEET_1047_b {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (stack.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() != 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
