package com.til.algorithm.baekjoon_naver_intern.graph_traversal;

import java.io.IOException;

/**
 * Created by Youn on 2022/06/16.
 * Title : 알파벳 (https://www.acmicpc.net/problem/1987)
 * Hint  : Backtracking, DFS
 *         "첫째 줄에 말이 지날 수 있는 최대의 칸 수를 출력한다"
 */
public class BOJ_1987_Test {
    static int r = 2, c = 4;
    static boolean[] visited;
    static int max = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map = {{2, 0, 0, 1}, {0, 3, 2, 1}};

    public static void main(String[] args) throws IOException {
        visited = new boolean[26];

        dfs(0, 0, 0);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int count) {

        if (visited[map[x][y]]) {
            max = Math.max(max, count);
            return;
        } else {
            visited[map[x][y]] = true;
            System.out.println("x = " + x + " y = " + y);
            System.out.println("count = " + count);
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    System.out.println("nx = " + nx + " ny = " + ny);
                    dfs(nx, ny, count + 1);
                }
            }
            visited[map[x][y]] = false;

        }
    }

    private static void backtracking(int x, int y, int count) {
        visited[map[x][y]] = true;
        max = Math.max(max, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if (!visited[map[nx][ny]]) {
                    backtracking(nx, ny, count + 1);
                    visited[map[nx][ny]] = false;
                }
            }
        }
    }
}
