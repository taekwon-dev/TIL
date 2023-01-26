package com.til.algorithm.bigstone.hidden_1.graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private static int N;
    private static boolean[][] visited;
    private static int[][] map;
    private static int[] dx = {-2, -1, -2, -1, 2, 1, 2, 1};
    private static int[] dy = {-1, -2, 1, 2, -1, -2, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            map = new int[N][N];

            st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            bw.write(bfs(cx, cy, tx, ty) + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static int bfs(int cx, int cy, int tx, int ty) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(cx, cy, 0));
        visited[cx][cy] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == tx && node.y == ty) {
                return node.count;
            }

            for (int i = 0; i < 8; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) {
                    continue;
                }
                if (!visited[nx][ny]) {
                    queue.offer(new Node(nx, ny, node.count + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}