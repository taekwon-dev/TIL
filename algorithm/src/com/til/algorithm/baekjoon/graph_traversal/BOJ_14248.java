package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14248 {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static int s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        s = Integer.parseInt(br.readLine());
        dfs(s);
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static void dfs(int s) {
        if (s < 1 || s > n) {
            return;
        }
        visited[s] = true;
        dfs(s + arr[s]);
        dfs(s - arr[s]);
    }
}
