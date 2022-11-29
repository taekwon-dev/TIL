package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {

    private static int n;
    private static int[] arr;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;
    private static int[] ops = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void backtracking(int depth, int sum) {
        if (depth == n) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i]--;
                if (i == 0) {
                    backtracking(depth + 1, sum + arr[depth]);
                } else if (i == 1) {
                    backtracking(depth + 1, sum - arr[depth]);
                } else if (i == 2) {
                    backtracking(depth + 1, sum * arr[depth]);
                } else if (i == 3) {
                    backtracking(depth + 1, sum / arr[depth]);
                }
                ops[i]++;
            }
        }

    }
}
