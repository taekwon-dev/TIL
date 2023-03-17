package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static Queue<int[]> queue = new LinkedList<>();
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int wall) {
        if (wall == 3) {
            answer = Math.max(answer, spreadAndGetSafetySize());
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    backtracking(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int spreadAndGetSafetySize() {
        boolean[][] virus = new boolean[N][M];
        int[][] copyMap = copyMap();
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            virus[curr[0]][curr[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                    continue;
                }
                if (!virus[nx][ny] && copyMap[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    virus[nx][ny] = true;
                    copyMap[nx][ny] = 2;
                }
            }
        }
        return getSafetySize(copyMap);
    }

    private static int getSafetySize(int[][] copyMap) {
        int safetySize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    safetySize++;
                }
            }
        }
        return safetySize;
    }

    private static int[][] copyMap() {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
                if (copy[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        return copy;
    }
}