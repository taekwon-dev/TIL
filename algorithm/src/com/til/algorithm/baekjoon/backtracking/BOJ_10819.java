package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  차이를 최대로
 */
public class BOJ_10819 {
    static int n;
    static int[] arr;
    static int[] tmp;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        tmp = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0);
        System.out.println(max);
    }

    private static void backtracking(int depth) {
        if (depth == n) {
            max = Math.max(max, cal());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp[depth] = arr[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int cal() {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(tmp[i] - tmp[i + 1]);
        }
        return sum;
    }

}