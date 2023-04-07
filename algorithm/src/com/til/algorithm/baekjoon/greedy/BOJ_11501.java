package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] value = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                value[i] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            int max = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (value[i] > max) {
                    max = value[i];
                } else {
                    answer += max - value[i];
                }
            }
            bw.write(answer + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}