package com.til.algorithm.baekjoon.prefix_sum;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11441 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int M = Integer.parseInt(br.readLine());
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