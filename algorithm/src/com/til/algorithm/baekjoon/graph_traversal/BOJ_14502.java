package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {

    private static int n;
    private static int m;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean[][] visited;
    private static int[][] map;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(0);
        System.out.println(max);
    }

    private static void backtracking(int wall) {
        if (wall == 3) {
            spread();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    backtracking(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // 바이러스 퍼트리기
    private static void spread() {
        visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && copy[nx][ny] == 0) {
                        copy[nx][ny] = 2;
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        countSafeArea(copy);
    }

    private static void countSafeArea(int[][] copy) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 0) {
                    count++;
                }
            }
        }
        max = Math.max(max, count);
    }
}