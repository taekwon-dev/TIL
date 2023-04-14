package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {

    private static int N;
    private static boolean[][] visited;
    private static int[] dx = {-1, -2, -1, -2, 1, 2, 1, 2};
    private static int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            if (sx == ex && sy == ey) {
                bw.write("0" + "\n");
            } else {
                bw.write(bfs(sx, sy, ex, ey) + "\n");
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static int bfs(int sx, int sy, int ex, int ey) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == ex && now[1] == ey) {
                return now[2];
            }

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) {
                    continue;
                }
                if (!visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny, now[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}