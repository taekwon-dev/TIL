package com.til.algorithm.baekjoon.bigstone.week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4197 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int n;
    private static int m;
    private static char[][] map;
    private static int[][] fireDist;
    private static int[][] jihoonDist;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static Queue<Node> fireQ = new LinkedList<>();
    private static Queue<Node> jihoonQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n + 1][m + 1];
        fireDist = new int[n + 1][m + 1];
        jihoonDist = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(fireDist[i], -1);
            Arrays.fill(jihoonDist[i], -1);
        }
        for (int i = 1; i <= n; i++) {
            String row = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = row.charAt(j - 1);
                if (map[i][j] == 'F') {
                    fireQ.add(new Node(i, j));
                    fireDist[i][j] = 0;
                }
                if (map[i][j] == 'J') {
                    jihoonQ.add(new Node(i, j));
                    jihoonDist[i][j] = 0;
                }
            }
        }
        fire();
        int answer = jihoon();
        if (answer == -1) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        System.out.println(answer);
    }

    private static void fire() {
        while (!fireQ.isEmpty()) {
            Node node = fireQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                    if (map[nx][ny] == '#' || fireDist[nx][ny] >= 0) {
                        continue;
                    }
                    fireQ.add(new Node(nx, ny));
                    fireDist[nx][ny] = fireDist[node.x][node.y] + 1;
                }
            }
        }
    }

    private static int jihoon() {
        while (!jihoonQ.isEmpty()) {
            Node node = jihoonQ.poll();

            if (isOnEdge(node.x, node.y)) {
                return jihoonDist[node.x][node.y] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                    if (map[nx][ny] == '#' || jihoonDist[nx][ny] >= 0) {
                        continue;
                    }
                    if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= jihoonDist[node.x][node.y] + 1) {
                        continue;
                    }
                    jihoonQ.add(new Node(nx, ny));
                    jihoonDist[nx][ny] = jihoonDist[node.x][node.y] + 1;
                }
            }
        }
        return -1;
    }

    private static boolean isOnEdge(int x, int y) {
        if (x == 1 || x == n || y == 1 || y == m) {
            return true;
        }
        return false;
    }
}