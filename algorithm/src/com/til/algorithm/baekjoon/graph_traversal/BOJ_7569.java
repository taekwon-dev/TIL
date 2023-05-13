package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {

    private static int M;
    private static int N;
    private static int H;
    private static int[][][] map;
    private static int[] dx = {1, -1, 0, 0, 0, 0};
    private static int[] dy = {0, 0, 1, -1, 0, 0};
    private static int[] dh = {0, 0, 0, 0, 1, -1};
    private static Queue<int[]> queue = new LinkedList<>();
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[N][M][H];
        answer = -1;

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[n][m][h] = Integer.parseInt(st.nextToken());
                    if (map[n][m][h] == 1) {
                        queue.offer(new int[]{n, m, h});
                    }
                }
            }
        }

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowH = now[2];

            for (int i = 0; i < 6; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                int nh = nowH + dh[i];

                if (nx < 0 || ny < 0 || nh < 0 || nx > N - 1 || ny > M - 1 || nh > H - 1) {
                    continue;
                }
                if (map[nx][ny][nh] == 0) {
                    queue.offer(new int[]{nx, ny, nh});
                    map[nx][ny][nh] = map[nowX][nowY][nowH] + 1;
                }
            }
        }

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (map[n][m][h] == 0) {
                        return -1;
                    }
                    answer = Math.max(answer, map[n][m][h]);
                }
            }
        }
        if (answer == 1) {
            return 0;
        }
        return answer - 1;
    }
}