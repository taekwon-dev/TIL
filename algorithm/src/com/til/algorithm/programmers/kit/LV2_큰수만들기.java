package com.til.algorithm.programmers.kit;

import java.util.Stack;

public class LV2_큰수만들기 {

    public String solution(String number, int k) {
        char[] c = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char target = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < target && k-- > 0) {
                stack.pop();
            }
            stack.push(target);
        }
        for (int i = 0; i < c.length; i++) {
            c[i] = stack.get(i);
        }
        return new String(c);
    }
}