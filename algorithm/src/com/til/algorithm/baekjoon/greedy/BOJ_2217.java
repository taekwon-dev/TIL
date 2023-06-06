package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;

public class BOJ_2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[N];

        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);

        int answer = rope[N - 1];
        for (int i = 0; i < N - 1; i++) {
            if (answer < rope[i] * (N - i)) {
                answer = rope[i] * (N - i);
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}