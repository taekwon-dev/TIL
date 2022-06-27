package com.til.algorithm.dev_matching_2022.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/27.
 * Title : 미로탐색 (https://www.acmicpc.net/problem/2178)
 * Hint  : 최단거리, 모든 간선의 가중치가 1로 동일, BFS, 최단거리 카운트 시 시작 위치, 도착 위치 모두 포함, 항상 도착위치로 이동 할 수 있는 경우로 입력이 주어진다.
 */
public class BOJ_2178 {

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String row = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = row.charAt(j - 1) - '0';
            }
        }

        bfs(1, 1);
    }

    // 시작 위치 (1, 1) 로 고정
    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        // 시작 위치도 거리에 포함되므로 dist = 1 로 설정
        queue.offer(new Node(x, y, 1));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == n && node.y == m) {
                System.out.println(node.dist);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.offer(new Node(nx, ny, node.dist + 1));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
