package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 벽 부수고 이동하기 2
 * <p>
 * (1, 1) -> (N, M) 이동 과정에서 최단 경로로 이동하려고 한다. (시작, 끝 포함)
 * 이동 과정에서 벽을 한 개 부수고 이동하는 것이 최단경로라면 벽을 K 까지 부수고 이동하여도 된다.
 * <p>
 * BOJ_2206 벽 부수고 이동하기
 * <p>
 * N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000), K(1 ≤ K ≤ 10)
 * <p>
 * 특정 노드에 방문
 * <p>
 * 1. 벽을 부수지 않고 이동
 * <p>
 * 2. 벽을 부수고 이동
 * - K 개 까지 부술 수 있으므로, 현재 내가 부술 수 있는 벽의 개수 < K 조건을 만족해야 한다.
 * <p>
 * <p>
 * visited[x][y][z] = x, y 좌표에 벽을 z 개 까지 부수고 방문 했는 지 여부
 * <p>
 * 예를 들어,
 * <p>
 * [x][y] - 1 (벽)
 * <p>
 * [x - 1][y - 1][2] 상태에서 [x][y] 도달할 때 벽을 부수고 오면 [x][y][3]
 * <p>
 * [x][y] - 0 (~벽)
 * <p>
 * [x - 1][y - 1][2] 상태에서 [x][y] 도달하면 [x][y][2] = true
 */
public class BOJ_14442 {
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

    static int n, m, k;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            String row = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = row.charAt(j - 1) - '0';
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 1, 1, 0));
        visited[1][1][0] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == n && node.y == m) {
                return node.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                    if (map[nx][ny] == 0) {
                        // 다음 방문 노드가 벽이 아닌 경우
                        if (!visited[nx][ny][node.wall]) {
                            queue.add(new Node(nx, ny, node.dist + 1, node.wall));
                            visited[nx][ny][node.wall] = true;
                        }
                    } else {
                        // 다음 방문 노드가 벽인 경우
                        if (node.wall < k && !visited[nx][ny][node.wall + 1]) {
                            queue.add(new Node(nx, ny, node.dist + 1, node.wall + 1));
                            visited[nx][ny][node.wall + 1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
