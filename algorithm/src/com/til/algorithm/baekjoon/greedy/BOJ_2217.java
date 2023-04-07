package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;

public class BOJ_2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] weight = new int[N];

        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(weight);

        int max = weight[N - 1];
        for (int i = 0; i < N - 1; i++) {
            if (weight[i] * (N - i) > max) {
                max = weight[i] * (N - i);
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}