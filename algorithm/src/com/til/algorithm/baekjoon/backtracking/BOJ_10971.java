package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  외판원 순회 2
 *
 */
public class BOJ_10971 {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            backtracking(0, i, i, 0);
        }
        System.out.println(min);
    }

    private static void backtracking(int depth, int prev, int start, int cost) {
        visited[start] = true;

        if (depth == n - 1) {
            if (map[prev][start] != 0) {
                min = Math.min(min, cost + map[prev][start]);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (map[prev][i] != 0) {
                    backtracking(depth + 1, i, start, cost + map[prev][i]);
                }
                visited[i] = false;
            }
        }
    }
}
