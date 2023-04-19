package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][] copy;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
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
        wall(0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void wall(int depth) {
        if (depth == 3) {
            spreadVirus();
            answer = Math.max(answer, getSafeSize());
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    wall(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void spreadVirus() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        copy = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
                if (copy[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] virus = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = virus[0] + dx[i];
                int ny = virus[1] + dy[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                    continue;
                }
                if (!visited[nx][ny] && copy[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    copy[nx][ny] = 2;
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static int getSafeSize() {
        int size = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] == 0) {
                    size++;
                }
            }
        }
        return size;
    }
}