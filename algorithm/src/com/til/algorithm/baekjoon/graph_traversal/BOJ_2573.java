package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2573 {

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
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int ice = -1;
        int region = 0;

        while (true) {
            if (ice == 0) {
                bw.write(0 + "\n");
                break;
            } else {
                region = getRegion();
                if (region >= 2) {
                    bw.write(answer + "\n");
                    break;
                }
            }
            ice = getIce();
            answer++;
            region = 0;
        }
        bw.flush();
        bw.close();
        br.read();
    }

    private static int getRegion() {
        int region = 0;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    dfs(i, j);
                    region++;
                }
            }
        }
        return region;
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                continue;
            }
            if (!visited[nx][ny] && map[nx][ny] != 0) {
                dfs(nx, ny);
            }
        }
    }

    private static int getIce() {
        int ice = 0;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    visited[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                            continue;
                        }
                        if (!visited[nx][ny] && map[nx][ny] == 0) {
                            if (map[i][j] > 0) {
                                map[i][j]--;
                            }
                        }
                    }
                    if (map[i][j] > 0) {
                        ice++;
                    }
                }
            }
        }
        return ice;
    }
}