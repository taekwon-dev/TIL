package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17836 {
    static class Node {
        int x;
        int y;
        int cost;
        boolean hasGram;

        public Node(int x, int y, int cost, boolean hasGram) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.hasGram = hasGram;
        }
    }
    static int n, m, t;
    static boolean[][][] visited;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1][m + 1][2];
        map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = bfs();
        if (result == -1) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 1, 0, false));
        visited[1][1][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.cost > t) {
                break;
            }

            if (node.x == n && node.y == m) {
                return node.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                    if (!node.hasGram) {
                        if (!visited[nx][ny][0] && map[nx][ny] == 0) {
                            queue.add(new Node(nx, ny, node.cost + 1, node.hasGram));
                            visited[nx][ny][0] = true;
                        } else if (!visited[nx][ny][0] && map[nx][ny] == 2) {
                            queue.add(new Node(nx, ny, node.cost + 1, true));
                            visited[nx][ny][0] = true;
                        }
                    } else {
                        if (!visited[nx][ny][1]) {
                            queue.add(new Node(nx, ny, node.cost + 1, node.hasGram));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
