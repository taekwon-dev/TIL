package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static Queue<Node> cheeseQ = new LinkedList<>();
    private static int currCheeseNum;
    private static int prevCheeseNum;
    private static int hour;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            currCheeseNum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        currCheeseNum++;
                        cheeseQ.offer(new Node(i, j));
                    }
                }
            }
            if (currCheeseNum == 0) {
                bw.write(hour + "\n");
                bw.write(prevCheeseNum + "\n");
                break;
            }
            prevCheeseNum = currCheeseNum;
            visited = new boolean[N][M];
            mark(0, 0);
            melt();
            hour++;
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void mark(int x, int y) {
        visited[x][y] = true;
        map[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                continue;
            }
            if (!visited[nx][ny] && (map[nx][ny] == 0 || map[nx][ny] == -1)) {
                map[nx][ny] = -1;
                mark(nx, ny);
            }
        }
    }

    private static void melt() {
        visited = new boolean[N][M];
        while (!cheeseQ.isEmpty()) {
            Node cheese = cheeseQ.poll();
            visited[cheese.x][cheese.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cheese.x + dx[i];
                int ny = cheese.y + dy[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == -1) {
                    map[cheese.x][cheese.y] = 0;
                }
            }
        }
    }
}