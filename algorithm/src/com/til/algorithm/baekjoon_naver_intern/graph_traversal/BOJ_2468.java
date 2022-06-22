package com.til.algorithm.baekjoon_naver_intern.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/16.
 * Title : 안전 영역 (https://www.acmicpc.net/problem/2468)
 * Hint  : Brute Force (1 ~ 100)
 */
public class BOJ_2468 {
    static int n, count = 0, max = 0;
    static int[][] map, transMap;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 높이 1 ~ 100 -> 매번 안전 영역의 수를 계산
        for (int h = 0; h <= 100; h++) {
            transMap = new int[n][n];
            count = 0;
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] <= h) {
                        transMap[i][j] = 0;
                    } else {
                        transMap[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (transMap[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count += 1;
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (transMap[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }



}
