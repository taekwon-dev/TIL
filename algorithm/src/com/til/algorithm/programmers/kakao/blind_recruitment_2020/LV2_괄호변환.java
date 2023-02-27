package com.til.algorithm.programmers.kakao.blind_recruitment_2020;

import java.util.Stack;

public class LV2_괄호변환 {

    public String solution(String p) {
        String answer = recursion(p);
        return answer;
    }

    private String recursion(String s) {
        if (s.length() == 0) {
            return "";
        }
        String u = "";
        String v = "";
        int open = 0;
        int close = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            u += s.charAt(i);
            if (open == close) {
                v = s.substring(i + 1);
                break;
            }
        }
        if (isCorrect(u)) {
            return u += recursion(v);
        }

        String temp = "(";
        temp += recursion(v);
        temp += ")";
        u = u.substring(1, u.length() - 1);
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                temp += ')';
            } else {
                temp += '(';
            }
        }
        return temp;
    }

    private boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
                continue;
            }
            if (stack.isEmpty() || stack.peek() == ')') {
                return false;
            }
            stack.pop();
        }
        return true;
    }
}
