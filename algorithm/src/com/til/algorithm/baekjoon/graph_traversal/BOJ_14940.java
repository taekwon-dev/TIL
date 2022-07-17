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
    static int[][] answer;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        answer = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    answer[i][j] = 0;
                    queue.add(new Node(i, j));
                } else if (map[i][j] == 1) {
                    answer[i][j] = -1;
                }
            }
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 각 지점 별로 목적지 까지의 거리 채우기
    private static void bfs() {

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.x][node.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];


                if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                        answer[nx][ny] = answer[node.x][node.y] + 1;
                    }
                }
            }
        }
    }
}
