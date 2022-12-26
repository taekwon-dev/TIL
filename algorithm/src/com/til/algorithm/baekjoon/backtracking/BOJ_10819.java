package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819 {

    private static int n;
    private static boolean[] visited;
    private static int[] arr;
    private static int[] copy;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        arr = new int[n];
        copy = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0);
        System.out.println(max);
    }

    private static void backtracking(int depth) {
        if (depth == n) {
            max = Math.max(max, calculate());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                copy[depth] = arr[i];
                visited[i] = true;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int calculate() {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(copy[i] - copy[i + 1]);
        }
        return sum;
    }
}