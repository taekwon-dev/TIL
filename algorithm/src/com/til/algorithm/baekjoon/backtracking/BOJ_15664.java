package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15664 {

    private static int n;
    private static int m;
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backtracking(0, 0, "");
    }

    private static void backtracking(int depth, int index, String s) {
        if (depth == m) {
            System.out.println(s);
            return;
        }
        int prev = 0;
        for (int i = index; i < n; i++) {
            if (!visited[i] && prev != arr[i]) {
                prev = arr[i];
                visited[i] = true;
                backtracking(depth + 1, i, s + arr[i] + " ");
                visited[i] = false;
            }
        }
    }
}