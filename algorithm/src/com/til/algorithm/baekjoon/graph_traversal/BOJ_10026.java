package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026 {
    static int n;
    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    count++;
                }
            }
        }
        int count_rg = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs_rg(i, j, map[i][j]);
                    count_rg++;
                }
            }
        }
        System.out.println(count + " " + count_rg);
    }

    private static void dfs(int x, int y, char c) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (!visited[nx][ny] && map[nx][ny] == c) {
                    dfs(nx, ny, c);
                }
            }
        }
    }

    private static void dfs_rg(int x, int y, char c) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (c == 'R' || c == 'G') {
                    if (!visited[nx][ny] && (map[nx][ny] == 'R' || map[nx][ny] == 'G')) {
                        dfs_rg(nx, ny, c);
                    }
                } else if (c == 'B') {
                    if (!visited[nx][ny] && map[nx][ny] == c) {
                        dfs_rg(nx, ny, c);
                    }
                }
            }
        }
    }
}