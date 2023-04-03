package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17521 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long coin = 0;
        int[] chart = new int[N];

        for (int i = 0; i < N; i++) {
            chart[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N - 1; i++) {
            if (chart[i] < chart[i + 1]) {
                if (W >= chart[i]) {
                    coin += W / chart[i];
                    W %= chart[i];
                } else if (chart[i] > chart[i + 1]) {
                    W += coin * chart[i];
                    coin = 0;
                }
            }
        }
        W += coin * chart[N - 1];

        bw.write(W + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}