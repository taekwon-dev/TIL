package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long answer = 0;
        if (N % 2 == 0) {
            long loss = arr[0] + arr[N - 1];
            for (int i = 0; i < N / 2; i++) {
                if (loss < arr[i] + arr[N - 1 - i]) {
                    loss = arr[i] + arr[N - 1 - i];
                }
            }
            answer = loss;
        } else {
            long loss = arr[N - 1];
            for (int i = 0; i < N / 2; i++) {
                if (loss < arr[i] + arr[N - 2 - i]) {
                    loss = arr[i] + arr[N - 2 - i];
                }
            }
            answer = loss;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}