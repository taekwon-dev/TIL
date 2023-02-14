package com.til.algorithm.bigstone.week_5;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14888 {

    private static int N;
    private static int[] arr;
    private static int[] operation;
    private static int max;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        operation = new int[4];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

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

    private static void backtracking(int depth, int result) {
        if (depth == N - 1) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        for (int i = 0; i < operation.length; i++) {
            if (operation[i] > 0) {
                operation[i]--;
                if (i == 0) {
                    backtracking(depth + 1, result + arr[depth + 1]);
                } else if (i == 1) {
                    backtracking(depth + 1, result - arr[depth + 1]);
                } else if (i == 2) {
                    backtracking(depth + 1, result * arr[depth + 1]);
                } else if (i == 3) {
                    backtracking(depth + 1, result / arr[depth + 1]);
                }
                operation[i]++;
            }
        }
    }
}