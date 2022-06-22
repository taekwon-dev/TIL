package com.til.algorithm.baekjoon_naver_intern.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/16.
 * Title : 다리 만들기
 * Hint  :
 */
public class BOJ_2146 {

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

    static int n, result = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int landNum = 2; // 섬 이름을 2, 3, 4 .. 순서로 지정 (기존 육지가 1로 설정되어 있으므로)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    nameLand(i, j, landNum);
                    landNum += 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 2) {
                    visited = new boolean[n][n];
                    bfs(i, j);
                }
            }
        }

        System.out.println(result);
    }

    private static void nameLand(int x, int y, int landNum) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, landNum));
        visited[x][y] = true;
        map[x][y] = landNum;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.offer(new Node(nx, ny, landNum));
                        visited[nx][ny] = true;
                        map[nx][ny] = landNum;
                    }
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 0));
        visited[x][y] = true;
        int currLandNum = map[x][y];

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny] && map[nx][ny] != currLandNum) {
                        if (map[nx][ny] == 0) {
                            queue.offer(new Node(nx, ny, node.dist + 1));
                            visited[nx][ny] = true;
                        } else {
                            result = Math.min(result, node.dist);
                        }
                    }
                }
            }
        }
    }
}
