package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/22.
 * Title : 쉬운 최단거리 (https://www.acmicpc.net/problem/14940)
 * Hint  : 최소비용, 가중치가 1로 동일
 */
public class BOJ_14940 {

    static int n, m;
    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    result[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else if (map[i][j] == 1) {
                    result[i][j] = -1;
                } else {
                    result[i][j] = 0;
                }
            }
        }

        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            int[] currs = queue.poll();
            int currX = currs[0];
            int currY = currs[1];
            visited[currX][currY] = true;

            for (int i = 0; i < 4; i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        result[nx][ny] = result[currX][currY] + 1;
                    }
                }
            }
        }
    }
}
