package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17836 {

    private static int N;
    private static int M;
    private static int T;
    private static int[][] map;
    private static boolean[][][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = bfs();

        if (result == -1 || result > T) {
            bw.write("Fail" + "\n");
        } else {
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 1, 0, 0});
        visited[1][1][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == N && now[1] == M) {
                return now[2];
            }
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 1 || ny < 1 || nx > N || ny > M) {
                    continue;
                }
                if (now[3] == 0) {
                    if (!visited[nx][ny][0]) {
                        if (map[nx][ny] == 0) {
                            queue.offer(new int[]{nx, ny, now[2] + 1, 0});
                        } else if (map[nx][ny] == 2) {
                            queue.offer(new int[]{nx, ny, now[2] + 1, 1});
                        }
                        visited[nx][ny][0] = true;
                    }
                } else {
                    if (!visited[nx][ny][1]) {
                        queue.offer(new int[]{nx, ny, now[2] + 1, 1});
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
        return -1;
    }
}