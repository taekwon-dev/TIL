package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/28.
 * Title : 섬의 개수 (https://www.acmicpc.net/problem/4963)
 * Hint  : 가로, 세로, 대각선
 */
public class BOJ_4963 {

    static int h, w;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h + 1][w + 1];
            visited = new boolean[h + 1][w + 1];
            result = 0;

            for (int i = 1; i < h + 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < w + 1; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i < h + 1; i++) {
                for (int j = 1; j < w + 1; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        dfs(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && ny >= 1 && nx < h + 1 && ny < w + 1) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
