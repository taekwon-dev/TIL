package com.til.algorithm.baekjoon.bigstone.week_1;

import java.io.*;
import java.util.Stack;

public class BOJ_3986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        while (n-- > 0) {
            if (isGoodWord(br.readLine())) {
                answer++;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isGoodWord(String word) {
        Stack<Character> stack = new Stack<>();
        for (char c : word.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}