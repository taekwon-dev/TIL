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
 *
 *
 *  " BFS - 최단경로 "
 *  https://nulls.co.kr/graph/141
 *
 *  BFS 순회 방식을 보면,
 *
 *  루트를 기준으로
 *  - 거리 : 1
 *  - 거리 : 2
 *  - 거리 : 3
 *  .
 *  .
 *  .
 *  순으로 탐색을 한다.
 *
 *  이 문제에 위 개념을 적용하면,
 *
 *  거리가 1인 대상 중 - 벽을 부수고 거리가 1 , 벽을 부수지 않고 거리가 1 이 모두 포함되어 있다는 것을 알 수 있다.
 *
 *  ----
 *
 *  (1, 1)에서 (N, M)의 위치까지 이동하려 하는데,
 *  이때 최단 경로로 이동하려 한다. -> BFS (각 간선 별 가중치가 모두 1로 동일)
 *  최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다. -> 카운트 조건 (시작, 끝점 모두 포함)
 *
 */
public class BOJ_2206 {
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
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1][2]; // 방문 여부 + 벽을 부수고 방문 했는 지 여부

        for (int i = 1; i <= n; i++) {
            String row = br.readLine();
            for (int j = 1; j <= m; j++) {
                // char to int (아스키 코드 '0' 빼기를 통해 숫자 변환)
                map[i][j] = row.charAt(j - 1) - '0';
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        // 시작 위치도 카운트 포함이므로, 거리를 1로 초기화
        queue.offer(new Node(1, 1, 1, 0));
        visited[1][1][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == n && node.y == m) {
                return node.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 벽을 최대 한 개 까지 부수고 이동할 수 있다.
                // 다음 위치가 벽이 아니라면, 현재 벽을 1번 이상 부순지 여부가 중요하지 않다.
                // 다음 위치가 벽이라면, 현재 벽을 1번 이상 부순지 여부가 중요하다.
                    // 0번 부순 경우, 벽을 부수고 이동할 수 있다.
                    // 1번 부순 경우, 해당 벽으로 이동할 수 없다.
                if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                    // 다음 위치가 벽이 아니라면,
                    if (map[nx][ny] == 0 && !visited[nx][ny][node.wall]) {
                        // 이동거리를 하나 추가하고, 벽 부순 개수는 그대로 둔다.
                        queue.offer(new Node(nx, ny, node.dist + 1, node.wall));
                        visited[nx][ny][node.wall] = true;
                    // 다음 위치가 벽이라면, 벽을 0번 부순 상태여야 하고, 벽을 부수고 해당 위치를 방문한 적이 없어야 한다.
                    } else if (map[nx][ny] == 1 && node.wall == 0 && !visited[nx][ny][1]) {
                        queue.offer(new Node(nx, ny, node.dist + 1, node.wall + 1));
                        visited[nx][ny][node.wall + 1] = true;
                    }
                }
            }
        }
        return -1;
    }

}
