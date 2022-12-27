package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971 {

    private static int n;
    private static boolean[] visited;
    private static int[][] map;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        map = new int[n + 1][n + 1];
        StringTokenizer st = null;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= n; i++) {
            backtracking(i, i, 0, 0);
        }
        System.out.println(min);
    }

    private static void backtracking(int start, int prev, int depth, int cost) {
        visited[start] = true;
        if (depth == n - 1) {
            if (map[prev][start] != 0) {
                min = Math.min(min, cost + map[prev][start]);
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && map[prev][i] != 0) {
                visited[i] = true;
                backtracking(start, i, depth + 1, cost + map[depth][i]);
                visited[i] = false;
            }
        }
    }
}