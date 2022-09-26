package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int m, n;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 익은 토마토 큐 대기열에 추가
                if (map[i][j] == 1) {
                    queue.add(new Node(i, j));
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 0) {
                        queue.add(new Node(nx, ny));
                        map[nx][ny] = map[node.x][node.y] + 1;
                    }
                }
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
                answer = Math.max(answer, map[i][j]);
            }
        }

        if (answer == 1) {
            // 최초 저장 시 모든 토마토가 익은 상태
            return 0;
        } else {
            // 익은 토마토가 1로 설정되어 있어서 날짜 계산시 -1 처리 필요
            return answer - 1;
        }
    }
}
