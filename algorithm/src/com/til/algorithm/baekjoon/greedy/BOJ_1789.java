package com.til.algorithm.baekjoon.greedy;

import java.io.*;

public class BOJ_1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long S = Long.parseLong(br.readLine());
        long sum = 0L;
        int answer = 0;

        for (int i = 1; ; i++) {
            if (sum > S) {
                break;
            }
            sum += i;
            answer++;
        }

        bw.write(answer - 1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}