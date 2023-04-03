package com.til.algorithm.baekjoon.implementation;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int line = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < line; j++) {
                int temp = map[j][j];

                // ←
                for (int k = j + 1; k < M - j; k++) {
                    map[j][k - 1] = map[j][k];
                }
                // ↑
                for (int k = j + 1; k < N - j; k++) {
                    map[k - 1][M - 1 - j] = map[k][M - 1 - j];
                }
                // →
                for (int k = M - 2 - j; k >= j; k--) {
                    map[N - 1 - j][k + 1] = map[N - 1 - j][k];
                }
                // ↓
                for (int k = N - 2 - j; k >= j; k--) {
                    map[k + 1][j] = map[k][j];
                }
                map[j + 1][j] = temp;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer.append(map[i][j]).append(" ");
            }
            answer.append("\n");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}