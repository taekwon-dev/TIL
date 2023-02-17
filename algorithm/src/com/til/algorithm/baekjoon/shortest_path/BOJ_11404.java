package com.til.algorithm.baekjoon.shortest_path;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  플로이드-워셜 최단거리 알고리즘 O(N^3)
 *  모든 쌍 최단 거리 알고리즘, u에서 v로 가는데 경유점을 거치는게 더 빠르다면 완하를 시켜 dist[u][v]를 갱신 시킨다.
 */
public class BOJ_11404 {

    private static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = INF;
                if (i == j) {
                    map[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[from][to] = Math.min(map[from][to], cost);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == INF) {
                    sb.append("0" + " ");
                } else {
                    sb.append(map[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}