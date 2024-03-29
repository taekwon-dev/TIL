package com.til.algorithm.bigstone.hidden_1.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14888 {

    private static int N;
    private static int[] operations;
    private static int[] arr;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        operations = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operations.length; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
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
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < operations.length; i++) {
            if (operations[i] > 0) {
                operations[i]--;
                if (i == 0) {
                    backtracking(depth + 1, sum + arr[depth + 1]);
                } else if (i == 1) {
                    backtracking(depth + 1, sum - arr[depth + 1]);
                } else if (i == 2) {
                    backtracking(depth + 1, sum * arr[depth + 1]);
                } else if (i == 3) {
                    backtracking(depth + 1, sum / arr[depth + 1]);
                }
                operations[i]++;
            }
        }
    }
}