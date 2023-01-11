package com.til.algorithm.bigstone.week_3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14497 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N;
    private static int M;
    private static int X1;
    private static int Y1;
    private static int X2;
    private static int Y2;
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N + 1][M + 1];

        st = new StringTokenizer(br.readLine());
        X1 = Integer.parseInt(st.nextToken());
        Y1 = Integer.parseInt(st.nextToken());
        X2 = Integer.parseInt(st.nextToken());
        Y2 = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String row = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = row.charAt(j - 1);
            }
        }

        int answer = 0;
        while (!flag) {
            bfs();
            answer++;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        int[][] copy = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                copy[i][j] = map[i][j];
            }
        }

        visited = new boolean[N + 1][M + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(X1, Y1));
        visited[X1][Y1] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == X2 && node.y == Y2) {
                flag = true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 1 || ny < 1 || nx > N || ny > M) {
                    continue;
                }
                if (!visited[nx][ny] && copy[nx][ny] == '1') {
                    visited[nx][ny] = true;
                    map[nx][ny] = '0';
                    continue;
                }
                if (!visited[nx][ny] && (copy[nx][ny] == '0' || copy[nx][ny] == '#')) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }
}