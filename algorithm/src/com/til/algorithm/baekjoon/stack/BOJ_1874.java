package com.til.algorithm.baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class BOJ_1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int start = 0;

        StringBuilder answer = new StringBuilder();
        while (N-- > 0) {
            int val = Integer.parseInt(br.readLine());

            if (val > start) {
                for (int i = start + 1; i <= val; i++) {
                    stack.push(i);
                    answer.append('+').append("\n");
                }
                start = val;
            } else if (stack.peek() != val) {
                answer = new StringBuilder("NO");
                break;
            }
            stack.pop();
            answer.append('-').append("\n");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}