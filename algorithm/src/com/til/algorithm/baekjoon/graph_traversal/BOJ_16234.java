package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  인구 이동
 *
 *  연합 = 국경선이 열리는 조건 + 인접한 국가
 *
 *  하루 단위 아래 작업 반복
 *  1) 국경선 연다 = 국경선이 열리는 조건 + 인접한 국가 찾기
 *  2) 연합이 되면, 해당 연합 내 인구 이동 시작 (연합의 인구수 / 인접한 국가 수) 로 연합 내 모든 국가 인구수 세팅
 *
 */
public class BOJ_16234 {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Node> union;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());
    }

    private static int move() {
        int answer = 0;
        while (true) {
            boolean flag = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (union.size() > 1) {
                            // 인구 이동
                            flag = true;
                            int avg = sum / union.size();
                            for (Node node : union) {
                                map[node.x][node.y] = avg;
                            }
                        }
                    }
                }
            }
            if (!flag) return answer;
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

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (!visited[nx][ny]) {
                        int diff = Math.abs(map[node.x][node.y] - map[nx][ny]);
                        if (diff >= L && diff <= R) {
                            queue.add(new Node(nx, ny));
                            visited[nx][ny] = true;
                            union.add(new Node(nx, ny));
                            sum += map[nx][ny];
                        }
                    }
                }
            }
        }
        return sum;
    }
}
