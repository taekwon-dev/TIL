package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] value = new int[N];
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (value[i] > K) {
                continue;
            }
            int count = K / value[i];
            K -= value[i] * count;
            answer += count;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}