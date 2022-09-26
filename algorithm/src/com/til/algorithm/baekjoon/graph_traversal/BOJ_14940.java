package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {
    static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int n, m;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 2) {
                    map[i][j] = 0;
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true;
                } else if (val == 1) {
                    map[i][j] = -1;
                } else {
                    map[i][j] = val;
                }
            }
        }
        bfs();
        print2DArray();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == -1) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny, node.dist + 1));
                        map[nx][ny] = node.dist + 1;
                    }
                }
            }
        }
    }

    private static void print2DArray() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
