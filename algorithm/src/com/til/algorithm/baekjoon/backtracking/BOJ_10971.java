package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10971 {

    private static int N;
    private static int[][] map;
    private static boolean[] visited;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            backtracking(0, i, i, 0);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int start, int prev, int cost) {
        if (depth == N - 1) {
            if (map[prev][start] != 0) {
                cost += map[prev][start];
                answer = Math.min(answer, cost);
            }
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && map[prev][i] != 0) {
                visited[i] = true;
                backtracking(depth + 1, start, i, cost + map[prev][i]);
                visited[i] = false;
            }
        }
    }
}