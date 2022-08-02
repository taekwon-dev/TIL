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
 *  모든 지점 -> 목표 지점
 *
 *  0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점이다.
 *  입력에서 2는 단 한개이다.
 *
 *  시작점 = 목표 지점 (값이 2인 곳)
 *
 *  시작점으로부터 각 노드에 방문거리를 1씩 추가해서 거리를 구하기
 *  단 이미 0 (= 길이 아닌 곳)인 경우에는 0으로 출력
 *  시작점으로부터 도달할 수 없는 곳은 -1로 출력
 *
 *  (2 ≤ n ≤ 1000, 2 ≤ m ≤ 1000)
 *
 *  BFS - 거리별 특징
 *
 *  1 - 2 - 3 . .
 *    - 2 - 3 . .
 *        - 3 . .
 *
 *  각 지점 -> 목표 지점
 *  목표 지점 -> 각 지점까지의 거리
 *
 *  맵에서 목표 지점은 한 곳
 *
 *  목표 지점을 기준으로 BFS를 돌면서 하나씩 방문처리 (이 때 거리 정보 하나씩 추가하면서)
 *  원래 0으로 되어 있는 부분은 0으로 그대로 두면 되고,
 *  방문 할 수 없는 곳은 -1 처리 (BFS 끝내고, 1인 곳 -> -1로 처리)
 *
 */
public class BOJ_14940 {
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
    static int[][] rmap;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();
    static Queue<Node> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        rmap = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    // i, j -> 목표 지점
                    // 목표 지점은 시작 지점이므로 0으로 설정
                    rmap[i][j] = 0;
                    queue.offer(new Node(i, j));
                } else if (map[i][j] == 1) {
                    rmap[i][j] = -1;
                }
            }
        }
        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(rmap[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.x][node.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] != 0) {
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                        rmap[nx][ny] = rmap[node.x][node.y] + 1;
                    }
                }
            }
        }
    }


}
