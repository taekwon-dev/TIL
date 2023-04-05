package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15903 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] card = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            Arrays.sort(card);
            long sum = card[0] + card[1];
            card[0] = sum;
            card[1] = sum;
        }
        long answer = 0;
        for (long number : card) {
            answer += number;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}