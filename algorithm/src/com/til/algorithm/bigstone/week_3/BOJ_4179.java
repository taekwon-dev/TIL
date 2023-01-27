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
    private static int[][] jhMap;
    private static int[][] fireMap;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static Queue<Node> jhQ = new LinkedList<>();
    private static Queue<Node> fireQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        jhMap = new int[R][C];
        fireMap = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(jhMap[i], -1);
            Arrays.fill(fireMap[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = row.charAt(j);
                if (map[i][j] == 'J') {
                    jhMap[i][j] = 0;
                    jhQ.offer(new Node(i, j));
                    continue;
                }
                if (map[i][j] == 'F') {
                    fireMap[i][j] = 0;
                    fireQ.offer(new Node(i, j));
                }
            }
        }
        fire();
        int result = jh();
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

                if (nx < 0 || ny < 0 || nx > R - 1 || ny > C - 1) {
                    continue;
                }
                if (map[nx][ny] == '#' || fireMap[nx][ny] != -1) {
                    continue;
                }
                fireQ.offer(new Node(nx, ny));
                fireMap[nx][ny] = fireMap[fire.x][fire.y] + 1;
            }
        }
    }

    private static int jh() {
        while (!jhQ.isEmpty()) {
            Node jh = jhQ.poll();

            if (isOnEdge(jh.x, jh.y)) {
                // + 1 = 경계 값을 넘어서야 미로를 탈출하는 것이기 때문에, + 1 을 해서 반환
                return jhMap[jh.x][jh.y] + 1;
            }
            for (int i = 0; i < 4; i++) {
                int nx = jh.x + dx[i];
                int ny = jh.y + dy[i];

                if (nx < 0 || ny < 0 || nx > R - 1 || ny > C - 1) {
                    continue;
                }
                if (map[nx][ny] == '#' || jhMap[nx][ny] != -1) {
                    continue;
                }
                if (fireMap[nx][ny] != -1 && fireMap[nx][ny] <= jhMap[jh.x][jh.y] + 1) {
                    continue;
                }
                jhQ.offer(new Node(nx, ny));
                jhMap[nx][ny] = jhMap[jh.x][jh.y] + 1;
            }
        }
        return -1;
    }

    private static boolean isOnEdge(int x, int y) {
        if (x == 0 || y == 0 || x == R - 1 || y == C - 1) {
            return true;
        }
        return false;
    }
}