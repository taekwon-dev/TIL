package com.til.algorithm.baekjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {

    private static int n;
    private static int[][] map;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }
        dfs(n, 0, 0);
        System.out.println(sb.toString());
    }

    private static void dfs(int size, int x, int y) {
        if (size < 1) {
            return;
        }
        if (compress(size, x, y)) {
            sb.append(map[x][y]);
            return;
        }
        int halfSize = size / 2;
        sb.append("(");
        dfs(halfSize, x, y);
        dfs(halfSize, x, y + halfSize);
        dfs(halfSize, x + halfSize, y);
        dfs(halfSize, x + halfSize, y + halfSize);
        sb.append(")");
    }

    private static boolean compress(int size, int x, int y) {
        int init = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (init != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}