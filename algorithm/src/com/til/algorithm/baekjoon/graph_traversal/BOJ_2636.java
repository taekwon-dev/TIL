package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static Queue<int[]> cheeseQ = new LinkedList<>();
    private static int currCheeseNum;
    private static int prevCheeseNum;

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

        int year = 0;
        while (true) {
            currCheeseNum = getCurrCheeseNum();
            if (currCheeseNum == 0) {
                break;
            }
            prevCheeseNum = currCheeseNum;
            mark();
            melt();
            year++;
        }

        bw.write(year + "\n");
        bw.write(prevCheeseNum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getCurrCheeseNum() {
        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    cheeseQ.offer(new int[]{i, j});
                    num++;
                }
            }
        }
        return num;
    }

    private static void mark() {
        visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        map[0][0] = -1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                    continue;
                }
                if (!visited[nx][ny] && (map[nx][ny] == 0 || map[nx][ny] == -1)) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    map[nx][ny] = -1;
                }
            }
        }
    }

    private static void melt() {
        visited = new boolean[N][M];
        while (!cheeseQ.isEmpty()) {
            int[] cheese = cheeseQ.poll();
            visited[cheese[0]][cheese[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cheese[0] + dx[i];
                int ny = cheese[1] + dy[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1) {
                    continue;
                }
                if (!visited[nx][ny] && map[nx][ny] == -1) {
                    map[cheese[0]][cheese[1]] = 0;
                }
            }
        }
    }
}