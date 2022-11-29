package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {

    private static int n;
    private static boolean[] picked;
    private static int[][] map;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        picked = new boolean[n];
        map = new int[n][n];

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(0, 0);
        System.out.println(min);
    }

    private static void backtracking(int depth, int start) {
        if (depth == n / 2) {
            min = Math.min(min, minDiff());
            return;
        }
        for (int i = start; i < n; i++) {
            if (!picked[i]) {
                picked[i] = true;
                backtracking(depth + 1, i + 1);
                picked[i] = false;
            }
        }
    }

    private static int minDiff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (picked[i] && picked[j]) {
                    start += map[i][j];
                    start += map[j][i];
                } else if (!picked[i] && !picked[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }
        return Math.abs(start - link);
    }

}
