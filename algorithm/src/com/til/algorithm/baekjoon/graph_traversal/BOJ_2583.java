package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2583 {
    static int m, n, k;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int eachSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            color(lx, ly, rx, ry);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    dfs(i, j);
                    result.add(eachSize);
                    eachSize = 0;
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        StringBuilder sb = new StringBuilder();
        for (int size : result) {
            sb.append(size + " ");
        }
        System.out.println(sb.toString());
    }

    private static void color(int lx, int ly, int rx, int ry) {
        for (int i = lx + 1; i <= rx; i++) {
            for (int j = ly + 1; j <= ry; j++) {
                map[i][j] = 1;
            }
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        eachSize++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
