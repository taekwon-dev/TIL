package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    public static class Node {
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
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String row = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = row.charAt(j - 1) - '0';
            }
        }

        bfs(1, 1);
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 1));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == n && node.y == m) {
                System.out.println(node.dist);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.add(new Node(nx, ny, node.dist + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

}
