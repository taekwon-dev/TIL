package com.til.algorithm.baekjoon.bigstone.week_5;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14889 {

    private static int N;
    private static int[][] stat;
    private static boolean[] picked;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        stat = new int[N + 1 ][N + 1];
        picked = new boolean[N + 1];

        StringTokenizer st = null;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(0, 1);
        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int index) {
        if (depth == N / 2) {
            min = Math.min(min, diff());
            return;
        }
        for (int i = index; i < N; i++) {
            if (!picked[i]) {
                picked[i] = true;
                backtracking(depth + 1, i + 1);
                picked[i] = false;
            }
        }
    }

    private static int diff() {
        int start = 0;
        int link = 0;
        for (int i = 1; i <= N - 1; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (picked[i] && picked[j]) {
                    start += (stat[i][j] + stat[j][i]);
                } else if (!picked[i] && !picked[j]) {
                    link += (stat[i][j] + stat[j][i]);
                }
            }
        }
        return Math.abs(start - link);
    }
}