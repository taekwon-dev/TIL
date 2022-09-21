package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 빙산
 */
public class BOJ_2573 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int region_size = 0;
        int ice_num = -1;

        while (true) {
            if (ice_num == 0) {
                System.out.println(0);
                break;
            } else {
                region_size = getRegionSize();
                if (region_size >= 2) {
                    System.out.println(answer);
                    break;
                }
            }
            ice_num = melting();
            answer++;
            region_size = 0;
        }

    }

    private static int getRegionSize() {
        int count = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!visited[nx][ny] && map[nx][ny] != 0) {
                    dfs(nx, ny);
                }
            }
        }
    }

    private static int melting() {
        int count = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    visited[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                            if (!visited[nx][ny] && map[nx][ny] == 0) {
                                if (map[i][j] > 0) map[i][j]--;
                            }
                        }
                    }
                    if (map[i][j] > 0) count++;
                }
            }
        }
        return count;
    }


}
