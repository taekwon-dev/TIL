package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Youn on 2022/06/04.
 * Title : 적록색약 (https://www.acmicpc.net/problem/10026)
 * Hint  : DFS
 */
public class BOJ_10026_DFS {

    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String row = br.readLine();
            for (int j = 1; j <= n; j++) {
                map[i][j] = row.charAt(j - 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    result++;
                }
            }
        }
        sb.append(result + " ");

        visited = new boolean[n + 1][n + 1];
        result = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    result++;
                }
            }
        }

        sb.append(result);
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && ny >= 1 && nx < n + 1 && ny < n + 1) {
                if (!visited[nx][ny] && map[nx][ny] == map[x][y]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
