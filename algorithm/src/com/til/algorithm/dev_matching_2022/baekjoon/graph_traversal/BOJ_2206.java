package com.til.algorithm.dev_matching_2022.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/27.
 * Title : 벽 부수고 이동하기 (https://www.acmicpc.net/problem/2206) (시리즈)
 * Hint  : "벽을 한 개 까지 부수고 이동하여도 된다", 최단거리, 간선의 가중치가 모두 1로 동일, BFS
 *         시작 위치, 도착 위치는 항상 0, 시작하는 칸, 도착하는 칸 모두 포함해서 카운트, 도착 위치에 도달하지 못한 경우 -1 출력
 */
public class BOJ_2206 {
    /**
     *
     *  중요 ! 각 지점에 대해서 거리 / 벽 (부수고 도달 했는 지 또는 부수지 않고 도달 했는 지) -> 0 또는 1 (사이즈 2)
     */

    static class Node {
        int x;
        int y;
        int dist;
        int wall;

        public Node(int x, int y, int dist, int wall) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wall = wall;
        }
    }
    static int n, m;
    static int[][] map;
    static boolean[][][] visitied;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visitied = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1, 0));  // 시작하는 칸도 이동 거리에 포함
        visitied[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == n - 1 && node.y == m - 1) {
                return node.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 0) {
                        if (!visitied[nx][ny][node.wall]) {
                            queue.offer(new Node(nx, ny, node.dist + 1, node.wall));
                            visitied[nx][ny][node.wall] = true;
                        }
                    } else {
                        // 벽을 만난 상황에서, 벽을 부술 수 있는 조건일 때
                        if (!visitied[nx][ny][node.wall] && node.wall == 0) {
                            queue.offer(new Node(nx, ny, node.dist + 1, 1));
                            visitied[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

}
