package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  연산자 끼워넣기
 */
public class BOJ_14888 {
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

    private static void backtracking(int depth, int tmp) {
        if (depth == n) {
            max = Math.max(max, tmp);
            min = Math.min(min, tmp);
            return;
        }
        for (int j = 0; j < 4; j++) {
            if (ops[j] > 0) {
                ops[j]--;
                if (j == 0) {
                    backtracking(depth + 1, tmp + arr[depth]);
                } else if (j == 1) {
                    backtracking(depth + 1, tmp - arr[depth]);
                } else if (j == 2) {
                    backtracking(depth + 1, tmp * arr[depth]);
                } else if (j == 3) {
                    backtracking(depth + 1, tmp / arr[depth]);
                }
                ops[j]++;
            }
        }
    }
}
