package com.til.algorithm.baekjoon_pack_mg.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/16.
 * Title : 알파벳 (https://www.acmicpc.net/problem/1987)
 * Hint  : Backtracking, DFS
 *         "첫째 줄에 말이 지날 수 있는 최대의 칸 수를 출력한다"
 */
public class BOJ_1987 {
    static int r, c;
    static int[][] map;
    static boolean[] visited;
    static int max = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new boolean[26];

        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = row.charAt(j) - 'A';
            }
        }
        // dfs(0, 0, 0);
        backtracking(0, 0, 1);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int count) {

        if (visited[map[x][y]]) {
            max = Math.max(max, count);
            return;
        } else {
            visited[map[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
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
