package com.til.algorithm.bigstone.week_3;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  1) 불 관점
 *
 *  2) 지훈 관점
 *
 *  불이 이동하는 상황을 시뮬레이션 진행한 뒤, 지훈이가 미로를 탈출할 수 있는지를 판단
 */
public class BOJ_4197 {

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
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static char[][] map;
    private static int[][] jihoonDist;
    private static int[][] fireDist;
    private static Queue<Node> jihoonQ = new LinkedList<>();
    private static Queue<Node> fireQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R + 1][C + 1];
        jihoonDist = new int[R + 1][C + 1];
        fireDist = new int[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            Arrays.fill(jihoonDist[i], -1);
            Arrays.fill(fireDist[i], -1);
        }
        for (int i = 1; i <= R; i++) {
            String row = br.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = row.charAt(j - 1);
                if (map[i][j] == 'J') {
                    jihoonQ.add(new Node(i, j));
                    jihoonDist[i][j] = 0;
                } else if (map[i][j] == 'F') {
                    fireQ.add(new Node(i, j));
                    fireDist[i][j] = 0;
                }
            }
        }
        do_fire();
        int answer = do_jihoon();
        if (answer == -1) {
            bw.write("IMPOSSIBLE" + "\n");
        } else {
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void do_fire() {
        while (!fireQ.isEmpty()) {
            Node fire = fireQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = fire.x + dx[i];
                int ny = fire.y + dy[i];

                if (nx >= 1 && ny >= 1 && nx <= R && ny <= C) {
                    if (map[nx][ny] == '#' || fireDist[nx][ny] >= 0) {
                        continue;
                    }
                    fireQ.add(new Node(nx, ny));
                    fireDist[nx][ny] = fireDist[fire.x][fire.y] + 1;
                }
            }
        }
    }

    private static int do_jihoon() {
        while (!jihoonQ.isEmpty()) {
            Node jihoon = jihoonQ.poll();

            if (isOnEdge(jihoon.x, jihoon.y)) {
                return jihoonDist[jihoon.x][jihoon.y] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = jihoon.x + dx[i];
                int ny = jihoon.y + dy[i];

                if (nx >= 1 && ny >= 1 && nx <= R && ny <= C) {
                    if (map[nx][ny] == '#' || jihoonDist[nx][ny] >= 0) {
                        continue;
                    }
                    if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= jihoonDist[jihoon.x][jihoon.y] + 1) {
                        continue;
                    }
                    jihoonQ.add(new Node(nx, ny));
                    jihoonDist[nx][ny] = jihoonDist[jihoon.x][jihoon.y] + 1;
                }
            }
        }
        return -1;
    }

    private static boolean isOnEdge(int x, int y) {
        if (x == 1 || x == R || y == 1 || y == C) {
            return true;
        }
        return false;
    }
}