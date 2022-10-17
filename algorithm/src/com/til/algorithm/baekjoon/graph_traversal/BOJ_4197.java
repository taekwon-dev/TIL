package com.til.algorithm.baekjoon.graph_traversal;

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
    static int r, c;
    static char[][] map;
    static int[][] f_dist;
    static int[][] j_dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Node> fq = new LinkedList<>();
    static Queue<Node> jq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r + 1][c + 1];
        f_dist = new int[r + 1][c + 1];
        j_dist = new int[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            Arrays.fill(f_dist[i], -1);
            Arrays.fill(j_dist[i], -1);
        }
        for (int i = 1; i <= r; i++) {
            String row = br.readLine();
            for (int j = 1; j <= c; j++) {
                char c = row.charAt(j - 1);
                map[i][j] = c;
                if (c == 'F') {
                    fq.add(new Node(i, j));
                    f_dist[i][j] = 0;
                }
                if (c == 'J') {
                    jq.add(new Node(i, j));
                    j_dist[i][j] = 0;
                }
            }
        }
        f_moving();
        int result = j_moving();
        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        } else{
            System.out.println(result);
        }
    }

    private static void f_moving() {
        while (!fq.isEmpty()) {
            Node fire = fq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = fire.x + dx[i];
                int ny = fire.y + dy[i];
                if (nx >= 1 && ny >= 1 && nx <= r && ny <= c) {
                    if (map[nx][ny] == '#' || f_dist[nx][ny] >= 0) {
                        continue;
                    }
                    fq.add(new Node(nx, ny));
                    f_dist[nx][ny] = f_dist[fire.x][fire.y] + 1;
                }
            }
        }
    }

    private static int j_moving() {
        while (!jq.isEmpty()) {
            Node jihoon = jq.poll();

            if (isOnEdge(jihoon.x, jihoon.y)) {
                return j_dist[jihoon.x][jihoon.y] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = jihoon.x + dx[i];
                int ny = jihoon.y + dy[i];
                if (nx >= 1 && ny >= 1 && nx <= r && ny <= c) {
                    if (map[nx][ny] == '#' || j_dist[nx][ny] >= 0) {
                        continue;
                    }
                    if (f_dist[nx][ny] != -1 && f_dist[nx][ny] <= j_dist[jihoon.x][jihoon.y] + 1) {
                        continue;
                    }
                    jq.add(new Node(nx, ny));
                    j_dist[nx][ny] = j_dist[jihoon.x][jihoon.y] + 1;
                }
            }
        }
        return -1;
    }

    private static boolean isOnEdge(int x, int y) {
        if (x == 1 || x == r || y == 1 || y == c) {
            return true;
        } else {
            return false;
        }
    }

}
