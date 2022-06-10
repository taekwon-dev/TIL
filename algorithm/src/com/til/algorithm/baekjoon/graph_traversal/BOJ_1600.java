package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/04.
 * Title : 말이 되고픈 원숭이 (https://www.acmicpc.net/problem/1600)
 * Hint  : 벽 부수고 이동하기 시리즈 - 유사 문제
 */
public class BOJ_1600 {
    static class Node {
        int x;
        int y;
        int dist;
        int horse;

        public Node(int x, int y, int dist, int horse) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.horse = horse;
        }
    }
    static int w, h, k;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hy = {-2, -1, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h + 1][w + 1];
        visited = new boolean[h + 1][w + 1][k + 1];

        for (int i = 1; i <= h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 1, 0, 0));
        visited[1][1][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == h && node.y == w) {
                return node.dist;
            }

            for (int i = 0; i < 8; i++) {
                int nx = node.x + hx[i];
                int ny = node.y + hy[i];

                if (nx >= 1 && ny >= 1 && nx <= h && ny <= w) {
                    if (node.horse < k && !visited[nx][ny][node.horse + 1] && map[nx][ny] == 0) {
                        queue.offer(new Node(nx, ny, node.dist + 1, node.horse + 1));
                        visited[nx][ny][node.horse + 1] = true;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 1 && ny >= 1 && nx <= h && ny <= w) {
                    if (!visited[nx][ny][node.horse] && map[nx][ny] == 0) {
                        queue.offer(new Node(nx, ny, node.dist + 1, node.horse));
                        visited[nx][ny][node.horse] = true;
                    }
                }
            }
        }
        return -1;
    }
}
