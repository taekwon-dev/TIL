package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        int N = 0;
        int[] arr;
        while (TC-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
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