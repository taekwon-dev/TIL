package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/22.
 * Title : 토마토 (https://www.acmicpc.net/problem/7569)
 * Hint  : 최소 비용, 이동 방향 추가
 */

class Tomato {
    int x;
    int y;
    int h;

    Tomato(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}

public class BOJ_7579 {
    static int M, N, H;
    static int[][][] map;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N + 1][M + 1];

        for (int h = 1; h < H + 1; h++) {
            for (int n = 1; n < N + 1; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 1; m < M + 1; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                }
            }
        }

        bfs();
        int result = Integer.MIN_VALUE;
        for (int h = 1; h < H + 1; h++) {
            for (int n = 1; n < N + 1; n++) {
                for (int m = 1; m < M + 1; m++) {
                    if (map[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, map[h][n][m]);
                }
            }
        }
        System.out.println(result - 1);
    }

    private static void bfs() {
        Queue<Tomato> queue = new LinkedList<>();
        for (int h = 1; h < H + 1; h++) {
            for (int n = 1; n < N + 1; n++) {
                for (int m = 1; m < M + 1; m++) {
                    if (map[h][n][m] == 1) {
                        queue.add(new Tomato(n, m, h));
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            Tomato curr = queue.poll();
            int x = curr.x;
            int y = curr.y;
            int h = curr.h;

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nh = h + dh[i];

                if (nh >= 1 && nx >= 1 && ny >= 1 && nh < H + 1 && nx < N + 1 && ny < M + 1) {
                    if (map[nh][nx][ny] == 0) {
                        queue.add(new Tomato(nx, ny, nh));
                        map[nh][nx][ny] = map[h][x][y] + 1;
                    }
                }
            }
        }
    }
}
