package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_20115 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Integer[] cost = new Integer[N];

        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cost, Collections.reverseOrder());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if ((i + 1) % 3 == 0) {
                continue;
            }
            answer += cost[i];
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}