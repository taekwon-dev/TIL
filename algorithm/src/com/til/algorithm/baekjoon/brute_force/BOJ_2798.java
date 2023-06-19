package com.til.algorithm.baekjoon.brute_force;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2798 {

    private static int N;
    private static int M;
    private static int[] arr;
    private static int answer;

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

        backtracking(0, 0, 0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int start, int sum) {
        if (sum > M) {
            return;
        }
        if (depth == 3) {
            if (answer < sum) {
                answer = sum;
            }
            return;
        }
        for (int i = start; i < N; i++) {
            backtracking(depth + 1, i + 1, sum + arr[i]);
        }
    }
}