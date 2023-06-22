package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_15312 {

    private static final int[] ALPHABET = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    private static String A;
    private static String B;
    private static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        A = br.readLine();
        B = br.readLine();

        StringBuilder combination = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            combination.append(ALPHABET[A.charAt(i) - 'A']);
            combination.append(ALPHABET[B.charAt(i) - 'A']);
        }

        recursion(combination.toString());

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void recursion(String combination) {
        if (combination.length() == 2) {
            answer = combination;
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < combination.length() - 1; i++) {
            int left = combination.charAt(i) - '0';
            int right = combination.charAt(i + 1) - '0';
            sb.append((left + right) % 10);
        }
        recursion(sb.toString());
    }
}