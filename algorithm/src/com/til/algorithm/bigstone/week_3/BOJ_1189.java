package com.til.algorithm.bigstone.week_3;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1189 {

    private static int r;
    private static int c;
    private static int k;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = row.charAt(j);
            }
        }
        dfs(r - 1, 0, 1);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y, int dist) {
        if (dist > k) {
            return;
        }
        if ((x == 0 && y == c - 1) && dist == k) {
            answer++;
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if (!visited[nx][ny] && map[nx][ny] != 'T') {
                    dfs(nx, ny, dist + 1);
                }
            }
        }
        visited[x][y] = false;
    }
}