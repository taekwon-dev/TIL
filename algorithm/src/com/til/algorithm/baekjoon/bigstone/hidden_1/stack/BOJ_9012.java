package com.til.algorithm.baekjoon.bigstone.hidden_1.stack;

import java.io.*;
import java.util.Stack;

public class BOJ_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        while (n-- > 0) {
            stack.clear();
            String s = br.readLine();
            for (char c : s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                stack.push(c);
            }
            if (stack.isEmpty()) {
                bw.write("YES" + "\n");
                continue;
            }
            bw.write("NO" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}