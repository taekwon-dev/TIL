package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16956 {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Node> queue = new LinkedList<>();
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                char c = row.charAt(j);
                map[i][j] = c;
                if (c == 'W') {
                    queue.add(new Node(i, j));
                }
            }
        }
        bfs();
        if (flag) {
            System.out.println(0);
        } else {
            System.out.println(1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    if (!visited[nx][ny]) {
                        if (map[nx][ny] == '.') {
                            map[nx][ny] = 'D';
                            visited[nx][ny] = true;
                        }
                        else if (map[nx][ny] == 'S') {
                            flag = true;
                            return;
                        }
                    }
                }
            }
        }
    }
}
