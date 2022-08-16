package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *  적록색약
 *
 *  적록색약 = 빨강과 초록 차이를 거의 느끼기 힘듬 -> 이 문제에서 적록색약인 경우 초록색과 빨강은 같은 색으로 본다.
 *  구역 = 같은 색으로 이루어져 있다.
 *
 *  1) 적록색약인 사람이 봤을 때
 *  2) 아닌 사람이 봤을 때
 *  구역의 수를 구하는 프로그램을 작성하시오.
 *
 *  (1 ≤ N ≤ 100)
 5
 RRRBB
 GGBBB
 BBBRR
 BBRRR
 RRRRR
 */
public class BOJ_10026 {

    static int n, count;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        sb.append(count + " ");

        count = 0;
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        sb.append(count);
        System.out.println(sb.toString());
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        char currColor = map[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (!visited[nx][ny] && map[nx][ny] == currColor) {
                    dfs(nx, ny);
                }
            }
        }
    }

}
