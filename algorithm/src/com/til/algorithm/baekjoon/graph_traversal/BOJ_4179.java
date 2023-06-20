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
    private static int[][] fMap;
    private static int[][] jhMap;
    private static Queue<int[]> fQueue = new LinkedList<>();
    private static Queue<int[]> jhQueue = new LinkedList<>();
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        fMap = new int[R][C];
        jhMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(fMap[i], -1);
            Arrays.fill(jhMap[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = row.charAt(j);

                if (map[i][j] == 'F') {
                    fQueue.offer(new int[]{i, j});
                    fMap[i][j] = 0;
                    continue;
                }
                if (map[i][j] == 'J') {
                    jhQueue.offer(new int[]{i, j});
                    jhMap[i][j] = 0;
                }
            }
        }

        moveFire();
        int result = moveJH();

        if (result == -1) {
            bw.write("IMPOSSIBLE" + "\n");
        } else {
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void moveFire() {
        while (!fQueue.isEmpty()) {
            int[] fire = fQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = fire[0] + dx[i];
                int ny = fire[1] + dy[i];

                if (!validateRegion(nx, ny)) {
                    continue;
                }
                if (map[nx][ny] == '#') {
                    continue;
                }
                if (fMap[nx][ny] != -1) {
                    continue;
                }

                fQueue.offer(new int[]{nx, ny});
                fMap[nx][ny] = fMap[fire[0]][fire[1]] + 1;
            }
        }
    }

    private static int moveJH() {
        while (!jhQueue.isEmpty()) {
            int[] jh = jhQueue.poll();

            // Egde에 도달한 뒤 탈출하기 위해 + 1 처리
            if (isOnEdge(jh[0], jh[1])) {
                return jhMap[jh[0]][jh[1]] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = jh[0] + dx[i];
                int ny = jh[1] + dy[i];

                if (!validateRegion(nx, ny)) {
                    continue;
                }
                if (map[nx][ny] == '#') {
                    continue;
                }
                if (jhMap[nx][ny] != -1) {
                    continue;
                }
                // Fire가 이동하지 않거나, Fire보다 더 빨리 JH가 도달하는 경우만 이동가능
                if (fMap[nx][ny] == -1 || fMap[nx][ny] > jhMap[jh[0]][jh[1]] + 1) {
                    jhQueue.offer(new int[]{nx, ny});
                    jhMap[nx][ny] = jhMap[jh[0]][jh[1]] + 1;
                }
            }
        }
        return -1;
    }

    private static boolean validateRegion(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }

    private static boolean isOnEdge(int x, int y) {
        return x == 0 || y == 0 || x == R - 1 || y == C - 1;
    }
}