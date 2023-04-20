package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] distance = new long[N - 1];
        long[] price = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long answer = distance[0] * price[0];
        long minPrice = price[0];

        for (int i = 1; i < N - 1; i++) {
            if (minPrice > price[i]) {
                minPrice = price[i];
            }
            answer += minPrice * distance[i];
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}