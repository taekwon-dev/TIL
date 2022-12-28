package com.til.algorithm.baekjoon.bigstone.hidden_1.recurrsion;

import java.io.*;

public class BOJ_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        bw.write(factorial(n) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}