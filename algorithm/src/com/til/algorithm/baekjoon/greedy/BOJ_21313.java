package com.til.algorithm.baekjoon.greedy;

import java.io.*;

public class BOJ_21313 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        if (N % 2 == 0) {
            for (int i = 0; i < N / 2; i++) {
                answer.append("1 2").append(" ");
            }
        } else {
            for (int i = 0; i < N / 2; i++) {
                answer.append("1 2").append(" ");
            }
            answer.append("3");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}