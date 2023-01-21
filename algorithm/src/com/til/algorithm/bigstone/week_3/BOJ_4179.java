package com.til.algorithm.bigstone.week_3;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int R;
    private static int C;
    private static char[][] map;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static Queue<Node> jihoonQ = new LinkedList<>();
    private static Queue<Node> fireQ = new LinkedList<>();
    private static int[][] jihoonMap;
    private static int[][] fireMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        jihoonMap = new int[R][C];
        fireMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(jihoonMap[i], -1);
            Arrays.fill(fireMap[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = row.charAt(j);
                if (map[i][j] == 'J') {
                    jihoonQ.offer(new Node(i, j));
                    jihoonMap[i][j] = 0;
                    continue;
                }
                if (map[i][j] == 'F') {
                    fireQ.offer(new Node(i, j));
                    fireMap[i][j] = 0;
                    continue;
                }
            }
        }

        fire();
        int result = jihoon();
        if (result == -1) {
            bw.write("IMPOSSIBLE" + "\n");
        } else {
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void fire() {
        while (!fireQ.isEmpty()) {
            Node fire = fireQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = fire.x + dx[i];
                int ny = fire.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if (map[nx][ny] == '#' || fireMap[nx][ny] != -1) {
                        continue;
                    }
                    fireMap[nx][ny] = fireMap[fire.x][fire.y] + 1;
                    fireQ.offer(new Node(nx, ny));
                }
            }
        }
    }

    private static int jihoon() {
        while (!jihoonQ.isEmpty()) {
            Node jihoon = jihoonQ.poll();

            if (isOnEdge(jihoon.x, jihoon.y)) {
                return jihoonMap[jihoon.x][jihoon.y] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = jihoon.x + dx[i];
                int ny = jihoon.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if (map[nx][ny] == '#' || jihoonMap[nx][ny] != -1) {
                        continue;
                    }
                    if (fireMap[nx][ny] != -1 && fireMap[nx][ny] <= jihoonMap[jihoon.x][jihoon.y] + 1) {
                        continue;
                    }
                    jihoonQ.offer(new Node(nx, ny));
                    jihoonMap[nx][ny] = jihoonMap[jihoon.x][jihoon.y] + 1;
                }
            }

        }
        return -1;
    }

    private static boolean isOnEdge(int x, int y) {
        if (x == 0 || x == R - 1 || y == 0 || y == C - 1) {
            return true;
        }
        return false;
    }
}