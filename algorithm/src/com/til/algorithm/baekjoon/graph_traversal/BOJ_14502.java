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
 *  안전 영역의 최댓값
 *
 *  (3 ≤ N, M ≤ 8)
 *  세울 수 있는 벽 경우의 수 = 64C3 = 64 63 62 / 3 2 = 32 * 21 * 62 = 41664
 *
 *  각각의 경우의 수에서 벽을 세우고, 바이러스 퍼트리고, 안전영역 크기 구하기
 *  백트랙킹 - 완전탐색
 *
 *  https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-14502%EB%B2%88-%EC%97%B0%EA%B5%AC%EC%86%8C-%EC%9E%90%EB%B0%94Java
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
    static int[][] virus;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        virus = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == 3) {
            // 벽을 세 개 세운 상태에서 안전영역 크기 계산
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
                virus[i][j] = map[i][j];
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (virus[nx][ny] == 0) {
                        virus[nx][ny] = 2;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }
        // 바이러스 전파 뒤 안전영역 크기 계산
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virus[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }
}
