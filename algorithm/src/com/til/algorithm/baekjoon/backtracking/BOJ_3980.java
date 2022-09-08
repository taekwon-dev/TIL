package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  선발 명단
 */
public class BOJ_3980 {
    static int tc;
    static int[][] map;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        tc = Integer.parseInt(br.readLine());
        while (tc --> 0) {
            max = Integer.MIN_VALUE;
            visited = new boolean[11];
            map = new int[11][11];
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
            if (!visited[i]) {
                if (map[depth][i] == 0) continue;
                visited[i] = true;
                backtracking(depth + 1, sum + map[depth][i]);
                visited[i] = false;
            }
        }
    }


}
