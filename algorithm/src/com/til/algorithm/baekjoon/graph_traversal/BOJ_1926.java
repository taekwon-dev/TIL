package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1926 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int paint;
    private static int size;
    private static int maxSize;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || map[i][j] == 0) {
                    continue;
                }
                size = 0;
                dfs(i, j);
                if (maxSize < size) {
                    maxSize = size;
                }
                paint++;
            }
        }

        bw.write(paint + "\n");
        bw.write(maxSize + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        size++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                continue;
            }
            if (!visited[nx][ny] && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}