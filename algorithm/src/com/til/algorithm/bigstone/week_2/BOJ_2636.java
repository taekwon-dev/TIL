package com.til.algorithm.bigstone.week_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {

    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][] melted;
    private static boolean[][] marked;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static Queue<int[]> queue = new LinkedList<>();
    private static int hour;
    private static int currCheeseNum;
    private static int lastCheeseNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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

        while (true) {
            currCheeseNum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1) {
                        currCheeseNum++;
                        queue.add(new int[]{i, j});
                    }
                }
            }
            if (currCheeseNum == 0) {
                bw.write(hour + "\n");
                bw.write(lastCheeseNum + "\n");
                break;
            }

            lastCheeseNum = currCheeseNum;
            marked = new boolean[n][m];
            mark(0, 0);
            melt();
            hour++;
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void mark(int x, int y) {
        marked[x][y] = true;
        map[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!marked[nx][ny] && (map[nx][ny] == 0 || map[nx][ny] == -1)) {
                    map[nx][ny] = -1;
                    mark(nx, ny);
                }
            }
        }
    }

    private static void melt() {
        melted = new boolean[n][m];
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            melted[curr[0]][curr[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!melted[nx][ny] && map[nx][ny] == -1) {
                        map[curr[0]][curr[1]] = 0;
                    }
                }
            }
        }
    }
}