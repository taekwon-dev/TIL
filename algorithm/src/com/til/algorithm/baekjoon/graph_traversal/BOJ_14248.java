package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14248 {

    private static int n;
    private static boolean[] visited;
    private static int[] arr;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        visited = new boolean[n + 1];
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = Integer.parseInt(br.readLine());
        dfs(start);

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int start) {
        if (start < 1 || start > n) {
            return;
        }
        visited[start] = true;
        dfs(start - arr[start]);
        dfs(start + arr[start]);
    }
}