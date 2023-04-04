package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14400 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] x = new int[N];
        int[] y = new int[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(x);
        Arrays.sort(y);

        int mx = x[(N - 1) / 2];
        int my = y[(N - 1) / 2];

        long answer = 0;
        for (int i = 0; i < N; i++) {
            answer += Math.abs(mx - x[i]) + Math.abs(my - y[i]);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}