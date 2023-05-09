package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427 {

    private static int H;
    private static int W;
    private static char[][] map;
    private static int[][] fireMap;
    private static int[][] sgMap;
    private static Queue<int[]> fireQ = new LinkedList<>();
    private static Queue<int[]> sgQ = new LinkedList<>();
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            fireMap = new int[H][W];
            sgMap = new int[H][W];

            for (int i = 0; i < H; i++) {
                Arrays.fill(fireMap[i], -1);
                Arrays.fill(sgMap[i], -1);
            }

            for (int i = 0; i < H; i++) {
                String row = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = row.charAt(j);
                    if (map[i][j] == '*') {
                        fireQ.offer(new int[]{i, j});
                        fireMap[i][j] = 0;
                        continue;
                    }
                    if (map[i][j] == '@') {
                        sgQ.offer(new int[]{i, j});
                        sgMap[i][j] = 0;
                    }
                }
            }
            move_fire();
            int result = move_sg();
            if (result == -1) {
                bw.write("IMPOSSIBLE" + "\n");
            } else {
                bw.write(result + "\n");
            }
            bw.flush();
        }
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

                if (nx < 0 || ny < 0 || nx > H - 1 || ny > W - 1) {
                    continue;
                }
                if (map[nx][ny] == '#' || fireMap[nx][ny] != -1) {
                    continue;
                }
                fireQ.offer(new int[]{nx, ny});
                fireMap[nx][ny] = fireMap[fireX][fireY] + 1;
            }
        }
    }

    private static int move_sg() {
        while (!sgQ.isEmpty()) {
            int[] sg = sgQ.poll();
            int sgX = sg[0];
            int sgY = sg[1];

            if (isOnEdge(sgX, sgY)) {
                return sgMap[sgX][sgY] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = sgX + dx[i];
                int ny = sgY + dy[i];

                if (nx < 0 || ny < 0 || nx > H - 1 || ny > W - 1) {
                    continue;
                }
                if (map[nx][ny] == '#' || sgMap[nx][ny] != -1) {
                    continue;
                }
                if (fireMap[nx][ny] == -1 || fireMap[nx][ny] > sgMap[sgX][sgY] + 1) {
                    sgQ.offer(new int[]{nx, ny});
                    sgMap[nx][ny] = sgMap[sgX][sgY] + 1;
                }
            }
        }
        return -1;
    }

    private static boolean isOnEdge(int x, int y) {
        return x == 0 || y == 0 || x == H - 1 || y == W - 1;
    }
}