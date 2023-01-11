package com.til.algorithm.bigstone.week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2583 {

    private static int m;
    private static int n;
    private static int k;
    private static boolean[][] visited;
    private static int[][] map;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        map = new int[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for (int x = lx; x < rx; x++) {
                for (int y = ly; y < ry; y++) {
                    map[x][y] = 1;
                }
            }
        }

        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    size = 0;
                    dfs(i, j);
                    sizes.add(size);
                }
            }
        }
        System.out.println(sizes.size());
        Collections.sort(sizes);
        StringBuilder sb = new StringBuilder();
        for (int size : sizes) {
            sb.append(size).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        size++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }
        }
    }
}