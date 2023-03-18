package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cost);

        int sum = 0;
        for (int c : cost) {
            sum += c;
        }
        int answer = sum;
        for (int i = cost.length - 1; i > 0; i--) {
            answer += sum - cost[i];
            sum -= cost[i];
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}