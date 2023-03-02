package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3980 {

    private static int[][] map;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        map = new int[11][11];

        for (int t = 0; t < tc; t++) {
            answer = Integer.MIN_VALUE;
            visited = new boolean[11];
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            backtracking(0, 0);
            bw.write(answer + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static void backtracking(int row, int sum) {
        if (row == 11) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int col = 0; col < 11; col++) {
            if (!visited[col] && map[row][col] != 0) {
                visited[col] = true;
                backtracking(row + 1, sum + map[row][col]);
                visited[col] = false;
            }
        }
    }
}