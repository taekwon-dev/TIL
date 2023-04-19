package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1182_b {

    private static int N;
    private static int S;
    private static int[] arr;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);

        if (S == 0) {
            bw.write(answer - 1 + "\n");
        } else {
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                answer++;
            }
            return;
        }

        backtracking(depth + 1, sum + arr[depth]);
        backtracking(depth + 1, sum);
    }
}