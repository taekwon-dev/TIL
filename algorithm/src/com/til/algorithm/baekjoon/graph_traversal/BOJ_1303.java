package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1303 {
    static int n, m;
    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int region_size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[m][n];
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = row.charAt(j);
            }
        }
        int w = 0;
        int b = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    if (map[i][j] == 'W') {
                        w += (region_size * region_size);
                    }
                    if (map[i][j] == 'B') {
                        b += (region_size * region_size);
                    }
                    region_size = 0;
                }
            }
        }
        System.out.println(w + " " + b);
    }

    private static void dfs(int x, int y, char flag) {
        visited[x][y] = true;
        region_size++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if (!visited[nx][ny] && map[nx][ny] == flag) {
                    dfs(nx, ny, flag);
                }
            }
        }
    }
}
