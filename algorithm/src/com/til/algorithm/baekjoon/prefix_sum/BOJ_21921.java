package com.til.algorithm.baekjoon.prefix_sum;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_21921 {

    private static int N;
    private static int X;
    private static int[] visitors;
    private static int count = 1;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        visitors = new int[N];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }
        sliding_window();
    }

    private static void sliding_window() {
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += visitors[i];
        }
        int max = sum;

        for (int i = X; i < N; i++) {
            sum -= visitors[i - X];
            sum += visitors[i];
            if (max < sum) {
                count = 0;
                count++;
                max = sum;
            } else if (max == sum) {
                count++;
            }
        }
        if (max == 0) {
            System.out.println("SAD");
            return;
        }
        sb.append(max).append("\n").append(count);
        System.out.println(sb.toString());
    }
}