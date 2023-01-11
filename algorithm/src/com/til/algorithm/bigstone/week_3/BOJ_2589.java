package com.til.algorithm.bigstone.week_3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589 {

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

    private static int N;
    private static int M;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int x, int y) {
        visited = new boolean[N][M];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            max = Math.max(max, node.dist);

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 'L') {
                        queue.add(new Node(nx, ny, node.dist + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}