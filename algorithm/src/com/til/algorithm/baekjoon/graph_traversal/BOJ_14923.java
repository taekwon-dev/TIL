package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/04.
 * Title : 미로 탈출 (https://www.acmicpc.net/problem/14923)
 * Hint  :
 */
public class BOJ_14923 {

    private static class Node {
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

    static int n, m, sx, sy, ex, ey;
    static int[][] map = new int[1001][1001];
    static boolean[][][] visited = new boolean[1001][1001][2];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sy = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ey = Integer.parseInt(st.nextToken());
        ex = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(sy, sx));
    }

    private static int bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        visited[y][x][0] = true;
        queue.add(new Node(y, x, 0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (x == ex && y == ey) {
                return node.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 1 && ny >= 1 && nx <= m && ny <= n) {
                    if (map[ny][nx] == 1) {
                        if (node.wall > 0) {
                            continue;
                        } else {
                            visited[ny][nx][1] = true;
                            queue.add(new Node(ny, nx, node.dist + 1, 1));
                        }
                    } else {
                        visited[nx][ny][node.wall] = true;
                        queue.add(new Node(ny, nx, node.dist + 1, node.wall));
                    }
                }
            }
        }
        return -1;
    }
}
