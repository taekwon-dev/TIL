package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            int N = Integer.parseInt(br.readLine());
            long[] arr = new long[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            long answer = 0;
            long max = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (max < arr[i]) {
                    max = arr[i];
                    continue;
                }
                answer += max - arr[i];
            }

            bw.write(answer + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}