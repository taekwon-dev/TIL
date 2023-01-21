package com.til.algorithm.bigstone.week_5;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14889 {

    private static int N;
    private static int[][] stat;
    private static boolean[] picked;
    private static int min = 4000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        stat = new int[N][N];
        picked = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0);
        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int index) {
        if (depth == N / 2) {
            // N(=짝수)명을 반으로 나누어 팀 구성하고, 각 팀의 능력치의 최솟값 구하기
            min = Math.min(min, diff());
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
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
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