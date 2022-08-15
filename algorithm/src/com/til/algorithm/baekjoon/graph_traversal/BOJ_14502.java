package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  연구소 (구현 + 완전탐색 + 그래프탐색)
 *
 *  연구소 내 바이러스가 위치
 *
 *  새로 세울 수 있는 벽의 개수는 3개, 꼭 3개를 세워야 한다.
 *
 *  벽 3개를 모두 세우고, 바이러스로부터 안전한 영역 = 안전 영역
 *
 *  안전 영역의 최댓값 -> 벽을 어떻게 세우는 지에 따라 안전영역의 크기가 달라진다.
 *
 *  0은 빈 칸
 *  1은 벽
 *  2는 바이러스
 *
 *  (3 ≤ N, M ≤ 8)
 *  세울 수 있는 벽 경우의 수 (각 노드 상태 상관 없이) = 64C3 = 64 63 62 / 3 2 = 32 * 21 * 62 = 41664
 *
 *  Backtracking + Graph Traversal
 *
 *  벽을 세울 수 있는 위치 -> 0 (빈칸) 인 곳.
 *
 */
public class BOJ_14502 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = Integer.MIN_VALUE;

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
            }
        }
        backtrakcing(0);
        System.out.println(max);
    }

    private static void backtrakcing(int depth) {
        if (depth == 3) {
            // 안전 영역의 최댓값 구하기
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    backtrakcing(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        int[][] copyMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = 2;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }
        int eachSafeSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    eachSafeSize++;
                }
            }
        }
        max = Math.max(max, eachSafeSize);
    }


}
