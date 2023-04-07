package com.til.algorithm.baekjoon.simulation;

import java.io.*;
import java.util.*;

public class BOJ_16234 {

    private static int N;
    private static int L;
    private static int R;
    private static int[][] map;
    private static boolean[][] visited;
    private static List<int[]> union;
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
                        if (union.size() >= 2) {
                            unified = true;
                            for (int[] nation : union) {
                                map[nation[0]][nation[1]] = sum / union.size();
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
        int sum = map[x][y];
        union = new ArrayList<>();
        union.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] nation = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = nation[0] + dx[i];
                int ny = nation[1] + dy[i];

                if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) {
                    continue;
                }
                int diff = Math.abs(map[nx][ny] - map[nation[0]][nation[1]]);
                if (!visited[nx][ny] && (diff >= L && diff <= R)) {
                    queue.offer(new int[]{nx, ny});
                    sum += map[nx][ny];
                    union.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return sum;
    }
}