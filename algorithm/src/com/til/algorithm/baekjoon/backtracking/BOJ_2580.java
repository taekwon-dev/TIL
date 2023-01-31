package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        sudoku(0, 0);
    }

    private static void sudoku(int row, int col) {
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }
        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }
        if (map[row][col] == 0) {
            for (int val = 1; val <= 9; val++) {
                if (isLocatable(row, col, val)) {
                    map[row][col] = val;
                    sudoku(row, col + 1);
                }
            }
            map[row][col] = 0;
            return;
        }
        sudoku(row, col + 1);
    }

    private static boolean isLocatable(int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == val) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == val) {
                return false;
            }
        }
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (map[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}