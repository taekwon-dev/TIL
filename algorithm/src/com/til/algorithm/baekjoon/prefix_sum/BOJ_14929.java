package com.til.algorithm.baekjoon.prefix_sum;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefixSum = new int[N + 1];
        prefixSum[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        long answer = 0;
        for (int i = 1; i < N; i++) {
            answer += arr[i] * (prefixSum[N] - prefixSum[i]);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}