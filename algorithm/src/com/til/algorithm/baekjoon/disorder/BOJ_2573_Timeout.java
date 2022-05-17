package com.til.algorithm.baekjoon.disorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/11.
 * Title : 빙산 (https://www.acmicpc.net/problem/2573)
 * Hint  : 매번 바뀌는 빙산 상태를 Input으로 영역 나누기
 */
public class BOJ_2573_Timeout {
    static int n; // 행
    static int m; // 열

    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static boolean[][] visited;
    static int subValue;
    static int partition;
    static int year;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 빙산이 최초 2개 이상의 영역으로 분리되는 시점까지
        while (true) {
            year++;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] - oneYear(i,j) <= 0) {
                        map[i][j] = 0;
                    }
                }
            }

            // DFS 영역 수 구하기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && map[i][j] != 0) {
                        dfs(i, j);
                        partition++;
                    }
                }
            }

            if (partition == 0) {
                System.out.println(0);
                break;
            }

            if (partition >= 2) {
                System.out.println(year);
                break;
            }
        }

    }



    // 각 정점 별로 빼야하는 값을 리턴
    private static int oneYear(int x, int y) {

        subValue = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 인접한 정점 검사 → (주어진 맵 범위 내에서)
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (map[nx][ny] == 0) {
                    subValue++;
                }
            }
        }
        return subValue;
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

}
