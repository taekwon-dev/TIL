package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3980 {

    private static int[][] map = new int[11][11];
    private static boolean[] assigned = new boolean[11];
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            answer = 0;
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
            if (!assigned[col] && map[row][col] != 0) {
                assigned[col] = true;
                backtracking(row + 1, sum + map[row][col]);
                assigned[col] = false;
            }
        }
    }
}