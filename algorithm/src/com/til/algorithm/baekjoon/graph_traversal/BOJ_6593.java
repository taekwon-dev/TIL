package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593 {

    private static int L;
    private static int R;
    private static int C;
    private static char[][][] map;
    private static int[] dx = {1, -1, 0, 0, 0, 0};
    private static int[] dy = {0, 0, 1, -1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0) {
                bw.write(answer.toString() + "\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }
            map = new char[L][R][C];

            int sx = 0;
            int sy = 0;
            int sz = 0;
            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String row = br.readLine();
                    for (int c = 0; c < C; c++) {
                        map[l][r][c] = row.charAt(c);
                        if (map[l][r][c] == 'S') {
                            sz = l;
                            sx = r;
                            sy = c;
                            map[l][r][c] = '.';
                        }
                    }
                }
                br.readLine();
            }
            bfs(sx, sy, sz);
        }
    }

    private static void bfs(int x, int y, int z) {
        boolean[][][] visited = new boolean[L][R][C];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, z, 0});
        visited[z][x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];
            int cz = curr[2];
            int cost = curr[3];

            if (map[cz][cx][cy] == 'E') {
                answer.append("Escaped in " + cost + " minute(s).").append("\n");
                return;
            }
            for (int i = 0; i < 6; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nz = cz + dz[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx > R - 1 || ny > C - 1 || nz > L - 1) {
                    continue;
                }
                if (visited[nz][nx][ny]) {
                    continue;
                }
                if (map[nz][nx][ny] == '.' || map[nz][nx][ny] == 'E') {
                    queue.offer(new int[]{nx, ny, nz, cost + 1});
                    visited[nz][nx][ny] = true;
                }
            }
        }
        answer.append("Trapped!").append("\n");
    }
}