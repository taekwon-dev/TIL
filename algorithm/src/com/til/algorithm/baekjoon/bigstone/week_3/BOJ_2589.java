package com.til.algorithm.baekjoon.bigstone.week_3;

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

    private static int n;
    private static int m;
    private static char[][] map;
    private static boolean[][] visited;
    private static int answer;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited = new boolean[n][m];
                if (map[i][j] == 'L') {
                    bfs(i, j, 0);
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int x, int y, int dist) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, dist));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == 'L') {
                        queue.add(new Node(nx, ny, now.dist + 1));
                        visited[nx][ny] = true;
                        answer = Math.max(answer, now.dist + 1);
                    }
                }
            }
        }
    }
}