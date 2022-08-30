package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  N과 M (11)
 */
public class BOJ_15665 {
    static int n, m;
    static int[] arr;
    static int[] sarr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        sarr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backtracking(0);
        System.out.println(sb.toString());
    }

    private static void backtracking(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(sarr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (prev != arr[i]) {
                prev = arr[i];
                sarr[depth] = arr[i];
                backtracking(depth + 1);
            }
        }
    }
}
