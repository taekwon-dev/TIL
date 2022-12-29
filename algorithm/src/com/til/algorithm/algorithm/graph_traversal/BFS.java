package com.til.algorithm.algorithm.graph_traversal;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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

    private static int[][] map = new int[3][3];
    private static boolean[][] visited = new boolean[3][3];
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        bfs(0, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int x, int y, int dist) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, dist));
        visited[x][y] = true;
        map[x][y] = dist;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                    if (!visited[nx][ny]) {
                        queue.add(new Node(nx, ny, node.dist + 1));
                        visited[nx][ny] = true;
                        map[nx][ny] = node.dist + 1;
                    }
                }
            }
        }
    }
}