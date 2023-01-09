package com.til.algorithm.baekjoon.bigstone.week_5;

import java.io.*;
import java.util.Stack;

public class BOJ_9935_stack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String parent = br.readLine();
        String pattern = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < parent.length(); i++) {
            stack.push(parent.charAt(i));
            if (stack.size() >= pattern.length()) {
                boolean contains = true;
                for (int j = 0; j < pattern.length(); j++) {
                    if (stack.get(stack.size() - pattern.length() + j) != pattern.charAt(j)) {
                        contains = false;
                        break;
                    }
                }
                if (contains) {
                    for (int k = 0; k < pattern.length(); k++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.size() == 0) {
            bw.write("FRULA" + "\n");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}