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
    private static int[][] jhMap;
    private static int[][] fireMap;
    private static Queue<int[]> jhQ;
    private static Queue<int[]> fireQ;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        jhMap = new int[R][C];
        fireMap = new int[R][C];
        jhQ = new LinkedList<>();
        fireQ = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            Arrays.fill(jhMap[i], -1);
            Arrays.fill(fireMap[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = row.charAt(j);
                if (map[i][j] == 'J') {
                    jhQ.offer(new int[]{i, j});
                    jhMap[i][j] = 0;
                    continue;
                }
                if (map[i][j] == 'F') {
                    fireQ.offer(new int[]{i, j});
                    fireMap[i][j] = 0;
                }
            }
        }


        move_fire();
        int result = jh_move();
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
            for (int i = 0; i < 4; i++) {
                int nx = fire[0] + dx[i];
                int ny = fire[1] + dy[i];

                if (nx < 0 || ny < 0 || nx > R - 1 || ny > C - 1) {
                    continue;
                }
                if (fireMap[nx][ny] == -1 && map[nx][ny] != '#') {
                    fireQ.offer(new int[]{nx, ny});
                    fireMap[nx][ny] = fireMap[fire[0]][fire[1]] + 1;
                }
            }
        }
    }

    private static int jh_move() {
        while (!jhQ.isEmpty()) {
            int[] jh = jhQ.poll();
            if (isOnEdge(jh[0], jh[1])) {
                return jhMap[jh[0]][jh[1]] + 1;
            }
            for (int i = 0; i < 4; i++) {
                int nx = jh[0] + dx[i];
                int ny = jh[1] + dy[i];

                if (nx < 0 || ny < 0 || nx > R - 1 || ny > C - 1) {
                    continue;
                }
                if (jhMap[nx][ny] != -1 || map[nx][ny] == '#') {
                    continue;
                }
                if (fireMap[nx][ny] != -1 && fireMap[nx][ny] <= jhMap[jh[0]][jh[1]] + 1) {
                    continue;
                }
                jhQ.offer(new int[]{nx, ny});
                jhMap[nx][ny] = jhMap[jh[0]][jh[1]] + 1;
            }
        }
        return -1;
    }

    private static boolean isOnEdge(int x, int y) {
        return x == 0 || x == R - 1 || y == 0 || y == C - 1;
    }
}