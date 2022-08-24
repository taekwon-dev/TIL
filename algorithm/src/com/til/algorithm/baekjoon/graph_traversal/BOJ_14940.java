package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  쉬운 최단거리
 *
 *  모든 지점에 대해서 목표지점까지의 거리
 *  (문제를 쉽게 만들기 위해 오직 가로와 세로로만 움직일 수 있다고 하자)
 *
 *  0은 갈 수 없는 땅
 *  1은 갈 수 있는 땅
 *  2는 목표지점
 *
 *  도달할 수 없는 곳을 -1로 표기 -> -1로 초기화 (단, 갈 수 없는 땅은 0으로 초기화)
 */

public class BOJ_14940 {

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
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true;
                    map[i][j] = 0;
                } else if (map[i][j] == 0) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = -1;
                }
            }
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {

                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == -1) {
                        queue.add(new Node(nx, ny, node.dist + 1));
                        map[nx][ny] = node.dist + 1;
                        visited[nx][ny] = true;
                    }
                }
            }
        }

    }
}
