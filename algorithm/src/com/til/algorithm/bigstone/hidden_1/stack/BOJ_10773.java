package com.til.algorithm.bigstone.hidden_1.stack;

import java.io.*;
import java.util.Stack;

public class BOJ_10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        String number = null;
        while (n-- > 0) {
            if ((number = br.readLine()).equals("0")) {
                stack.pop();
                continue;
            }
            stack.push(Integer.parseInt(number));
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}