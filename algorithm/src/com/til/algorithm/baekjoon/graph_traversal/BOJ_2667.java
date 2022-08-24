package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  단지번호붙이기
 *
 *  단지수 = 영역 수
 *  단지내 집의 수 = 영역 크기
 *
 *  0 = 집이 없는 곳
 *  1 = 집이 있는 곳
 */
public class BOJ_2667 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int regionSize = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }
        List<Integer> regions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    regions.add(regionSize);
                    regionSize = 1;
                }
            }
        }
        Collections.sort(regions);
        System.out.println(regions.size());
        for (int i = 0; i < regions.size(); i++) {
            System.out.println(regions.get(i));
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny);
                    regionSize++;
                }
            }
        }
    }
}
