package com.til.algorithm.baekjoon.stack;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10828 {

    private static int[] stack;
    private static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        stack = new int[N];

        StringBuilder answer = new StringBuilder();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    int item = Integer.parseInt(st.nextToken());
                    push(item);
                    break;
                case "pop":
                    answer.append(pop()).append("\n");
                    break;
                case "size":
                    answer.append(size()).append("\n");
                    break;
                case "empty":
                    answer.append(empty()).append("\n");
                    break;
                case "top":
                    answer.append(top()).append("\n");
                    break;
            }
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void push(int item) {
        stack[size] = item;
        size++;
    }

    private static int pop() {
        if (size == 0) {
            return -1;
        }
        int result = stack[size - 1];
        stack[size - 1] = 0;
        size--;
        return result;
    }

    private static int size() {
        return size;
    }

    private static int empty() {
        if (size == 0) {
            return 1;
        }
        return 0;
    }

    private static int top() {
        if (size == 0) {
            return -1;
        }
        return stack[size - 1];
    }
}