package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String row = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = row.charAt(j - 1) - '0';
            }
        }

        bw.write(bfs(1, 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int sx, int sy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy, 1});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int cost = now[2];

            if (nowX == N && nowY == M) {
                return now[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 1 || ny < 1 || nx > N || ny > M) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny, cost + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}