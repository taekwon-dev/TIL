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
        sudoku(0, 0);
    }

    private static void sudoku(int x, int y) {
        if (y == 9) {
            sudoku(x + 1, 0);
            return;
        }
        if (x == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
            return;
        }
        if (map[x][y] == 0) {
            for (int val = 1; val <= 9; val++) {
                if (isLocatable(x, y, val)) {
                    map[x][y] = val;
                    sudoku(x, y + 1);
                }
            }
            map[x][y] = 0;
            return;
        }
        sudoku(x, y + 1);
    }

    private static boolean isLocatable(int x, int y, int val) {
        for (int col = 0; col < 9; col++) {
            if (map[x][col] == val) {
                return false;
            }
        }
        for (int row = 0; row < 9; row++) {
            if (map[row][y] == val) {
                return false;
            }
        }
        int nx = (x / 3) * 3;
        int ny = (y / 3) * 3;
        for (int i = nx; i < nx + 3; i++) {
            for (int j = ny; j < ny + 3; j++) {
                if (map[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}