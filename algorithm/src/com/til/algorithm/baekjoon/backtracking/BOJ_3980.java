package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3980 {

    private static int[][] map;
    private static boolean[] visited;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        map = new int[11][11];
        visited = new boolean[11];
        for (int t = 0; t < tc; t++) {
            max = 0;
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            backtracking(0, 0);
            System.out.println(max);
        }
    }

    private static void backtracking(int depth, int sum) {
        if (depth == 11) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 11; i++) {
            if (!visited[i] && map[depth][i] != 0) {
                visited[i] = true;
                backtracking(depth + 1, sum + map[depth][i]);
                visited[i] = false;
            }
        }
    }
}