package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        String num = br.readLine();
        for (int i = 0; i < N; i++) {
            answer += num.charAt(i) - '0';
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}