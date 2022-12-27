package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16234 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int n;
    private static int l;
    private static int r;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static List<Node> union;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(unify());
    }

    private static int unify() {
        int answer = 0;
        while (true) {
            boolean flag = false;
            visited = new boolean[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (union.size() > 1) {
                            flag = true;
                        }
                        int avg = sum / union.size();
                        for (Node node : union) {
                            map[node.x][node.y] = avg;
                        }
                    }
                }
            }
            if (!flag) {
                return answer;
            }
            answer++;
        }
    }

    private static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;
        int sum = map[x][y];
        union = new ArrayList<>();
        union.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 1 && ny >= 1 && nx <= n && ny <= n) {
                    if (!visited[nx][ny]) {
                        int diff = Math.abs(map[node.x][node.y] - map[nx][ny]);
                        if (diff >= l && diff <= r) {
                            queue.add(new Node(nx, ny));
                            visited[nx][ny] = true;
                            sum += map[nx][ny];
                            union.add(new Node(nx, ny));
                        }
                    }
                }
            }
        }
        return sum;
    }
}