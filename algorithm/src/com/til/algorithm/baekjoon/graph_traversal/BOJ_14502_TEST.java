package com.til.algorithm.baekjoon.graph_traversal;

public class BOJ_14502_TEST {
    static int n;
    static int[][] map;
    public static void main(String[] args) {
        n = 3;
        map = new int[n][n];
        backtrakcing(0);
    }

    private static void backtrakcing(int depth) {
        if (depth == 3) {
            // 출력
            print2DArray();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    backtrakcing(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void print2DArray() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
