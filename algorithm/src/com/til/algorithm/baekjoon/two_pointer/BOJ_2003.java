package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2003 {

    private static int N;
    private static int M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int j = 0;
        int prefixSum = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            while (prefixSum < M && j < N) {
                prefixSum += arr[j];
                j++;
            }
            if (prefixSum == M) {
                answer++;
            }
            prefixSum -= arr[i];
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}