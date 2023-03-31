package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] loss = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            loss[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(loss);

        long max = loss[N - 1];
        if (N % 2 == 0) {
            for (int i = 0; i < N / 2; i++) {
                max = Math.max(max, loss[i] + loss[N - 1 - i]);
            }
        } else {
            for (int i = 0; i < N / 2; i++) {
                max = Math.max(max, loss[i] + loss[N - 2 - i]);
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}