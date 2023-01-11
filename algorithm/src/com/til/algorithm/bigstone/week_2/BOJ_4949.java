package com.til.algorithm.bigstone.week_2;

import java.io.*;
import java.util.Stack;

public class BOJ_4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = null;
        while (true) {
            input = br.readLine();
            if (input.equals(".")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            bw.write(solution(input, stack));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static String solution(String s, Stack<Character> stack) {
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
                continue;
            }
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no" + "\n";
                }
                stack.pop();
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no" + "\n";
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return "yes" + "\n";
        }
        return "no" + "\n";
    }
}