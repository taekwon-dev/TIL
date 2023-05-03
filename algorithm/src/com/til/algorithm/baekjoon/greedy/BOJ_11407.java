package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11407 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] > K) {
                continue;
            }
            int coin = K / arr[i];
            K -= arr[i] * coin;
            answer += coin;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}