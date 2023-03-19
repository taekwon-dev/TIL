package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {

    private static int R;
    private static int C;
    private static char[][] map;
    private static int[][] fireMap;
    private static int[][] jhMap;
    private static Queue<int[]> fireQ = new LinkedList<>();
    private static Queue<int[]> jhQ = new LinkedList<>();
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        fireMap = new int[R][C];
        jhMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(fireMap[i], -1);
            Arrays.fill(jhMap[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = row.charAt(j);
                if (map[i][j] == 'F') {
                    fireQ.offer(new int[]{i, j});
                    fireMap[i][j] = 0;
                    continue;
                }
                if (map[i][j] == 'J') {
                    jhQ.offer(new int[]{i, j});
                    jhMap[i][j] = 0;
                }
            }
        }
        move_fire();
        int result = move_jh();
        if (result == -1) {
            bw.write("IMPOSSIBLE" + "\n");
        } else {
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void move_fire() {
        while (!fireQ.isEmpty()) {
            int[] fire = fireQ.poll();
            int fireX = fire[0];
            int fireY = fire[1];

            for (int i = 0; i < 4; i++) {
                int nx = fireX + dx[i];
                int ny = fireY + dy[i];

                if (!validateRange(nx, ny)) {
                    continue;
                }
                if (map[nx][ny] != '#' && fireMap[nx][ny] == -1) {
                    fireQ.offer(new int[]{nx, ny});
                    fireMap[nx][ny] = fireMap[fireX][fireY] + 1;
                }
            }
        }
    }

    private static int move_jh() {
        while (!jhQ.isEmpty()) {
            int[] jh = jhQ.poll();
            int jhX = jh[0];
            int jhY = jh[1];

            if (isOnEdge(jhX, jhY)) {
                return jhMap[jhX][jhY] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = jhX + dx[i];
                int ny = jhY + dy[i];

                if (!validateRange(nx, ny)) {
                    continue;
                }
                if (map[nx][ny] == '#' || jhMap[nx][ny] != -1) {
                    continue;
                }
                if (fireMap[nx][ny] == -1 || fireMap[nx][ny] > jhMap[jhX][jhY] + 1) {
                    jhQ.offer(new int[]{nx, ny});
                    jhMap[nx][ny] = jhMap[jhX][jhY] + 1;
                }
            }
        }
        return -1;
    }

    private static boolean validateRange(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }

    private static boolean isOnEdge(int x, int y) {
        return x == 0 || x == R - 1 || y == 0 || y == C - 1;
    }
}