package com.til.algorithm.softeer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class LV2_장애물인식프로그램 {

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int block;
    private static ArrayList<Integer> blocks = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    block = 0;
                    dfs(i, j);
                    blocks.add(block);
                }
            }
        }

        Collections.sort(blocks);

        StringBuilder answer = new StringBuilder();
        answer.append(blocks.size()).append("\n");
        for (int i = 0; i < blocks.size(); i++) {
            answer.append(blocks.get(i)).append("\n");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y)
    {
        visited[x][y] = true;
        block++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) {
                continue;
            }
            if (!visited[nx][ny] && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}