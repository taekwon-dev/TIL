package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18809 {

    private static final int GREEN = 3;
    private static final int RED = 4;
    private static final int FLOWER = 5;

    static class Node {
        int time;
        int type;

        public Node(int time, int type) {
            this.time = time;
            this.type = type;
        }
    }

    private static int N;
    private static int M;
    private static int G;
    private static int R;
    private static int[][] map;
    private static int[] green;
    private static int[] red;
    private static boolean[] visited;
    private static ArrayList<int[]> candidate;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        green = new int[G];
        red = new int[R];
        visited = new boolean[10];
        candidate = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    candidate.add(new int[]{i, j});
                }
            }
        }
        do_green(0, 0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void do_green(int depth, int start) {
        if (depth == G) {
            do_red(0, 0);
            return;
        }
        for (int i = start; i < candidate.size(); i++) {
            if (!visited[i]) {
                green[depth] = i;
                visited[i] = true;
                do_green(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static void do_red(int depth, int start) {
        if (depth == R) {
            bfs();
            return;
        }
        for (int i = start; i < candidate.size(); i++) {
            if (!visited[i]) {
                red[depth] = i;
                visited[i] = true;
                do_red(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        Node[][] nodes = new Node[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                nodes[i][j] = new Node(0, 0);
            }
        }
        for (int i = 0; i < G; i++) {
            int[] now = candidate.get(green[i]);
            nodes[now[0]][now[1]] = new Node(0, GREEN);
            queue.offer(new int[]{now[0], now[1]});
        }
        for (int i = 0; i < R; i++) {
            int[] now = candidate.get(red[i]);
            nodes[now[0]][now[1]] = new Node(0, RED);
            queue.offer(new int[]{now[0], now[1]});
        }

        int flower = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (nodes[now[0]][now[1]].type == FLOWER) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    continue;
                }
                if (nodes[nx][ny].type == 0) {
                    nodes[nx][ny] = new Node(nodes[now[0]][now[1]].time + 1, nodes[now[0]][now[1]].type);
                    queue.offer(new int[]{nx, ny});
                } else if (nodes[nx][ny].type == GREEN) {
                    if (nodes[now[0]][now[1]].type == RED && nodes[nx][ny].time == nodes[now[0]][now[1]].time + 1) {
                        flower++;
                        nodes[nx][ny].type = FLOWER;
                    }
                } else if (nodes[nx][ny].type == RED) {
                    if (nodes[now[0]][now[1]].type == GREEN && nodes[nx][ny].time == nodes[now[0]][now[1]].time + 1) {
                        flower++;
                        nodes[nx][ny].type = FLOWER;
                    }
                }
            }
        }
        if (answer < flower) {
            answer = flower;
        }
    }
}