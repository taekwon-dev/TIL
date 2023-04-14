package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {

    private static int N;
    private static int L;
    private static int R;
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayList<int[]> unions;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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

        int answer = 0;
        while (true) {
            boolean unified = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (unions.size() >= 2) {
                            unified = true;
                            int avg = sum / unions.size();
                            for (int[] union : unions) {
                                map[union[0]][union[1]] = avg;
                            }
                        }
                    }
                }
            }
            if (!unified) {
                break;
            }
            answer++;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        unions = new ArrayList<>();
        unions.add(new int[]{x, y});
        int sum = map[x][y];

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) {
                    continue;
                }
                int abs = Math.abs(map[now[0]][now[1]] - map[nx][ny]);
                if (!visited[nx][ny] && (abs >= L && abs <= R)) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    unions.add(new int[]{nx, ny});
                    sum += map[nx][ny];
                }
            }
        }
        return sum;
    }
}