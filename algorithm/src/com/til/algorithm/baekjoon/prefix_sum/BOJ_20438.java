package com.til.algorithm.baekjoon.prefix_sum;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20438 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sum = new int[N + 3];
        boolean[] sleep = new boolean[N + 3];
        boolean[] present = new boolean[N + 3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int student = Integer.parseInt(st.nextToken());
            sleep[student] = true;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int student = Integer.parseInt(st.nextToken());
            if (sleep[student]) {
                continue;
            }
            int base = student;
            while (student < N + 3) {
                if (sleep[student]) {
                    student += base;
                    continue;
                }
                present[student] = true;
                student += base;
            }
        }

        for (int i = 3; i < N + 3; i++) {
            int flag = 0;
            if (!present[i]) {
                flag = 1;
            }
            sum[i] = sum[i - 1] + flag;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            bw.write(sum[to] - sum[from - 1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}