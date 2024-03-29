package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2580 {

    private static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(0, 0);
    }

    private static void backtracking(int row, int col) {
        if (col == 9) {
            backtracking(row + 1, 0);
            return;
        }
        if (row == 9) {
            printSudoku();
            System.exit(0);
        }
        if (map[row][col] == 0) {
            for (int val = 1; val <= 9; val++) {
                if (isLocatable(row, col, val)) {
                    map[row][col] = val;
                    backtracking(row, col + 1);
                }
            }
            map[row][col] = 0;
            return;
        }
        backtracking(row, col + 1);
    }

    private static boolean isLocatable(int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == val) {
                return false;
            }
            if (map[i][col] == val) {
                return false;
            }
        }
        int r = row / 3 * 3;
        int c = col / 3 * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (map[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printSudoku() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}