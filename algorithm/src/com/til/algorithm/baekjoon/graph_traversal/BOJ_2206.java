package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {

    private static int N;
    private static int M;
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
        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            String row = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = row.charAt(j - 1) - '0';
            }
        }

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 1, 1, 0});
        visited[1][1][0] = true;

        while (!queue.isEmpty()) {
            int now[] = queue.poll();

            if (now[0] == N && now[1] == M) {
                return now[2];
            }
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 1 || ny < 1 || nx > N || ny > M) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny][now[3]]) {
                        queue.offer(new int[]{nx, ny, now[2] + 1, now[3]});
                        visited[nx][ny][now[3]] = true;
                    }
                } else if (map[nx][ny] == 1) {
                    if (now[3] == 0 && !visited[nx][ny][1]) {
                        queue.offer(new int[]{nx, ny, now[2] + 1, 1});
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
        return -1;
    }
}