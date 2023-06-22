package com.til.algorithm.baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class BOJ_10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        int number = 0;
        Stack<Integer> stack = new Stack<>();

        while (K-- > 0) {
            number = Integer.parseInt(br.readLine());

            if (number == 0) {
                stack.pop();
                continue;
            }
            stack.push(number);
        }

        int answer = 0;
        for (int num : stack) {
            answer += num;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}