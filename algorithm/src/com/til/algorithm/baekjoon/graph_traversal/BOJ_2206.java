package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
    static class Node {
        int x;
        int y;
        int dist;
        int wall;

        public Node(int x, int y, int dist, int wall) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wall = wall;
        }
    }

    static int n, m;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1][2];
        for (int i = 1; i <= n; i++) {
            String row = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = row.charAt(j - 1) - '0';
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 1, 1, 0));
        visited[1][1][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == n && node.y == m) {
                return node.dist;
            }

            for (int i = 0; i < 4; i++) {

                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                    if (map[nx][ny] == 0) {
                        if (!visited[nx][ny][node.wall]) {
                            queue.add(new Node(nx, ny, node.dist + 1, node.wall));
                            visited[nx][ny][node.wall] = true;
                        }
                    } else if (map[nx][ny] == 1) {
                        if (node.wall == 0 && !visited[nx][ny][1]) {
                            queue.add(new Node(nx, ny, node.dist + 1, node.wall + 1));
                            visited[nx][ny][node.wall + 1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
