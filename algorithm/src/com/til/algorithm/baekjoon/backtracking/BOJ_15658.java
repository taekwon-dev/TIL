package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15658 {
    static int n;
    static int[] arr;
    static int[] ops;
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        ops = new int[4];

        st = new StringTokenizer(br.readLine());
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

    private static void backtracking(int depth, int num) {
        if (depth == n) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i]--;
                if (i == 0) {
                    backtracking(depth + 1, num + arr[depth]);
                } else if (i == 1) {
                    backtracking(depth + 1, num - arr[depth]);
                } else if (i == 2) {
                    backtracking(depth + 1, num * arr[depth]);
                } else if (i == 3) {
                    backtracking(depth + 1, num / arr[depth]);
                }
                ops[i]++;
            }
        }
    }
}
