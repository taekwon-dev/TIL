package com.til.algorithm.baekjoon.bigstone.week_3;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1987 {

    private static int R;
    private static int C;
    private static char[][] map;
    private static boolean[] visited = new boolean[26];
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = row.charAt(j);
            }
        }
        dfs(0, 0, 1);
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y, int dist) {
        max = Math.max(max, dist);
        visited[map[x][y] - 'A'] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if (!visited[map[nx][ny] - 'A']) {
                    visited[map[nx][ny] - 'A'] = true;
                    dfs(nx, ny, dist + 1);
                    visited[map[nx][ny] - 'A'] = false;
                }
            }
        }
    }
}