package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16208 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] len = new long[N];

        int S = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            len[i] = Long.parseLong(st.nextToken());
            S += len[i];
        }
        long answer = 0;
        for (int i = 0; i < N; i++) {
            long temp = len[i];
            S -= temp;
            answer += S * temp;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}