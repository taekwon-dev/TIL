package com.til.algorithm.baekjoon_pack_mg.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/16.
 * Title : 연구소 (https://www.acmicpc.net/problem/14502)
 * Hint  : 새로 세울 수 있는 벽의 개수는 3 (반드시 3개를 설치해야 한다)
 *         안전영역의 최댓값
 *         Brute Force (3개의 벽을 세우는 위치에 따라서 안전영역의 크기에 영향을 미침)
 *
 *         벽을 세워 놓고,
 *         바이러스를 퍼트리고,
 *         안전영역(빈 칸의 개수)를 센다.
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
    static int n, m, result = Integer.MIN_VALUE;
    static int[][] map, transMap;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(result);
    }

    // Combination
    private static void dfs(int wall) {
        if (wall == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        transMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transMap[i][j] = map[i][j];
            }
        }

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (transMap[i][j] == 2) {
                    queue.offer(new Node(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (transMap[nx][ny] == 0) {
                        transMap[nx][ny] = 2;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }
        countVirus(transMap);
    }

    private static void countVirus(int[][] transMap) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (transMap[i][j] == 0) {
                    count += 1;
                }
            }
        }
        result = Math.max(result, count);
    }
}
