package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  벽 부수고 이동하기
 *
 *  (1, 1) -> (N, M) 이동 과정에서 최단 경로로 이동하려고 한다. (시작, 끝 포함)
 *  이동 과정에서 벽을 한 개 부수고 이동하는 것이 최단경로라면 벽을 한 개까지 부수고 이동하여도 된다.
 *
 *  각 노드의 상태에서,
 *
 *  A -> B (A 에서 B 로 이동 할 때)
 *
 *  A -> B (벽을 부수지 않고, B에 방문)
 *  A -> B (벽을 부수고, B에 방문)
 *
 *  좌표 평면 (2차원 배열)에서 위 상태를 표현한다면,
 *
 *  visited[x][y] -> x, y 좌표에 방문 여부를 판단
 *
 *  여기에 벽을 부수고 방문 했는 지 여부 상태를 추가하기 위해 한 차원을 늘린다.
 *
 *  visited[x][y][z] -> x, y 좌표에 z (0 or 1) 벽을 부수고 방문 했는 지 여부 상태를 관리한다.
 *
 *  첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다.
 *  (1, 1)과 (N, M)은 항상 0이라고 가정하자.
 */
public class BOJ_2206 {
    static class Node {
        int x;
        int y;
        int dist; // 거리
        int wall; // 벽 개수 (0 또는 1)

        public Node(int x, int y, int dist, int wall) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wall = wall;
        }
    }
    static int n, m;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1][2];

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
        // (1, 1) 부터 시작, 시작 위치도 이동거리에 포함하므로 거리 1로 설정, 1은 항상 0 이므로 벽을 부수지 않고 시작점에 위치 가능
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
                    // 벽을 부수고 다음 노드에 방문하는 경우
                    // 1. 현재 내가 벽을 부술 수 있는 상태
                    // 2. 방문할 노드 기준, 이미 벽을 부수고 방문한 적이 없는 상태
                    // 3. 방문할 노드 기준, 해당 노드가 벽인 경우
                    if (node.wall == 0 && !visited[nx][ny][1] && map[nx][ny] == 1) {
                        queue.add(new Node(nx, ny, node.dist + 1, 1));
                        visited[nx][ny][1] = true;
                    }

                    // 벽을 부수지 않고 다음 노드에 방문하는 경우
                    if (!visited[nx][ny][node.wall] && map[nx][ny] == 0) {
                        queue.add(new Node(nx, ny, node.dist + 1, node.wall));
                        visited[nx][ny][node.wall] = true;
                    }
                }

            }
        }
        return -1;
    }

}
