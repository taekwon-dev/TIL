package com.til.algorithm.algorithm.backtracking;

/**
 * true false false
 * true false false
 * true false false
 *
 * true false false
 * true false false
 * false true false
 *
 * true false false
 * true false false
 * false false true
 *
 * true false false
 * false true false
 * true false false
 *
 * true false false
 * false true false
 * false true false
 *
 * true false false
 * false true false
 * false false true
 *
 * true false false
 * false false true
 * true false false
 *
 * true false false
 * false false true
 * false true false
 *
 * true false false
 * false false true
 * false false true
 *
 * false true false
 * true false false
 * true false false
 *
 * false true false
 * true false false
 * false true false
 *
 * false true false
 * true false false
 * false false true
 *
 * false true false
 * false true false
 * true false false
 *
 * false true false
 * false true false
 * false true false
 *
 * false true false
 * false true false
 * false false true
 *
 * false true false
 * false false true
 * true false false
 *
 * false true false
 * false false true
 * false true false
 *
 * false true false
 * false false true
 * false false true
 *
 * false false true
 * true false false
 * true false false
 *
 * false false true
 * true false false
 * false true false
 *
 * false false true
 * true false false
 * false false true
 *
 * false false true
 * false true false
 * true false false
 *
 * false false true
 * false true false
 * false true false
 *
 * false false true
 * false true false
 * false false true
 *
 * false false true
 * false false true
 * true false false
 *
 * false false true
 * false false true
 * false true false
 *
 * false false true
 * false false true
 * false false true
 */
public class N_QUEEN_기초 {

    private static int n = 3;
    private static boolean[][] map = new boolean[n][n];

    public static void main(String[] args) {
        backtracking(0);
    }

    private static void backtracking(int depth) {
        if (depth == n) {
            print2D();
            return;
        }
        for (int i = 0; i < n; i++) {
            map[depth][i] = true;
            backtracking(depth + 1);
            map[depth][i] = false;
        }
    }

    private static void print2D() {
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
