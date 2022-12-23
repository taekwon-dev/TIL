package com.til.algorithm.baekjoon.bigstone.week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468 {

    private static int n;
    private static boolean[][] visited;
    private static int[][] map;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st = null;
        int maxHeight = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int height = Integer.parseInt(st.nextToken());
                map[i][j] = height;
                maxHeight = Math.max(maxHeight, height);
            }
        }

        for (int h = 1; h <= maxHeight; h++) {
            flood(h);

            int size = 0;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] != 0) {
                        bfs(i, j);
                        size++;
                    }
                }
            }
            max = Math.max(max, size);
        }
        System.out.println(max);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny] && map[nx][ny] != 0) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    private static void flood(int height) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] <= height) {
                    map[i][j] = 0;
                }
            }
        }
    }
}