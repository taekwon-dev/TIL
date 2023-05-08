package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3980 {

    private static int[][] map = new int[11][11];
    private static boolean[] visited = new boolean[11];
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            answer = 0;
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            backtracking(0,0);

            bw.write(answer + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int sum) {
        if (depth == 11) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = 0; i < 11; i++) {
            if (!visited[i] && map[depth][i] != 0) {
                visited[i] = true;
                backtracking(depth + 1,sum + map[depth][i]);
                visited[i] = false;
            }
        }
    }
}