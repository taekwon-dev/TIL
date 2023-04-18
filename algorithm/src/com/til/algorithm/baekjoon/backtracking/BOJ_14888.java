package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14888 {

    private static int N;
    private static int[] arr;
    private static int[] operation;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        operation = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operation.length; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, arr[0]);

        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int sum) {
        if (depth == N - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for (int i = 0; i < operation.length; i++) {
            if (operation[i] > 0) {
                operation[i]--;
                if (i == 0) {
                    backtracking(depth + 1, sum + arr[depth + 1]);
                } else if (i == 1) {
                    backtracking(depth + 1, sum - arr[depth + 1]);
                } else if (i == 2) {
                    backtracking(depth + 1, sum * arr[depth + 1]);
                } else {
                    backtracking(depth + 1, sum / arr[depth + 1]);
                }
                operation[i]++;
            }
        }
    }
}