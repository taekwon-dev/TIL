package com.til.algorithm.baekjoon.disorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/12.
 * Title : 빙산 (https://www.acmicpc.net/problem/2573)
 * Hint  : 공통 작업을 효율적으로 처리하는 방법
 */
public class BOJ_2573 {

    static int n; // 행
    static int m; // 열

    static int[][] map;
    static int[][] melt;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int year;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        melt = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && map[i][j] != 0) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            if (count == 0) {
                System.out.println(0);
                break;
            }

            if (count >= 2) {
                System.out.println(year);
                break;
            }

            melting();
            year++;
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {

                if (map[nx][ny] == 0) {
                    melt[x][y]++;
                }

                if (!visited[nx][ny] && map[nx][ny] != 0) {
                    dfs(nx, ny);
                }
            }
        }
    }

    private static void melting() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] -= melt[i][j];

                if (map[i][j] < 0) {
                    map[i][j] = 0;
                }

                visited[i][j] = false;
                melt[i][j] = 0;
            }
        }
    }

}
