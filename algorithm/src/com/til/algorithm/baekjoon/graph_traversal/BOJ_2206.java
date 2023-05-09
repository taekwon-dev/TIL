package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {

    static class Node {
        int x;
        int y;
        int cost;
        int wall;

        public Node(int x, int y, int cost, int wall) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.wall = wall;
        }
    }

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            String row = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = row.charAt(j - 1) - '0';
            }
        }

        bw.write(bfs(1, 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int sx, int sy) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sx, sy, 1, 0));
        visited[sx][sy][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.x == N && now.y == M) {
                return now.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 1 || ny < 1 || nx > N || ny > M) {
                    continue;
                }
                if (map[nx][ny] == 0 && !visited[nx][ny][now.wall]) {
                    queue.offer(new Node(nx, ny, now.cost + 1, now.wall));
                    visited[nx][ny][now.wall] = true;
                    continue;
                }
                if (map[nx][ny] == 1 && (now.wall == 0 && !visited[nx][ny][1])) {
                    queue.offer(new Node(nx, ny, now.cost + 1, 1));
                    visited[nx][ny][1] = true;
                }
            }
        }
        return -1;
    }
}