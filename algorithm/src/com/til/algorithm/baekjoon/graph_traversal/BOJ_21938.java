package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21938 {
    static int n, m, t;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            int count = 0;
            for (int j = 0; j < m; j++) {
                while (st.hasMoreTokens()) {
                    count++;
                    sum += Integer.parseInt(st.nextToken());
                    if (count % 3 == 0) {
                        map[i][j] = sum;
                        sum = 0;
                        break;
                    }
                }
            }
        }
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] / 3 >= t) {
                    map[i][j] = 255;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 255) {
                    dfs(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);

    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!visited[nx][ny] && map[nx][ny] == 255) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
