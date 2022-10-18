package com.til.algorithm.baekjoon.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11404 {
    static int n, m;
    static int[][] map;
    static final int INF = 99 * 100000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = INF;
                if (i == j) {
                    map[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start][end] = Math.min(map[start][end], cost);
        }
        for (int v = 1; v <= n; v++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] > map[i][v] + map[v][j]) {
                        map[i][j] = map[i][v] + map[v][j];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == INF) {
                    map[i][j] = 0;
                }
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
