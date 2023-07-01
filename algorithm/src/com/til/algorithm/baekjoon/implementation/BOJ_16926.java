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
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int rotate = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < rotate; j++) {
                int temp = arr[j][j];

                // ←
                for (int k = j + 1; k < M - j; k++) {
                    arr[j][k - 1] = arr[j][k];
                }

                // ↑
                for (int k = j + 1; k < N - j; k++) {
                    arr[k - 1][M - 1 - j] = arr[k][M - 1 - j];
                }

                // →
                for (int k = M - 2 - j; k >= j; k--) {
                    arr[N - 1 - j][k + 1] = arr[N - 1 - j][k];
                }

                // ↓
                for (int k = N - 2 - j; k >= j; k--) {
                    arr[k + 1][j] = arr[k][j];
                }
                arr[j + 1][j] = temp;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer.append(arr[i][j]).append(" ");
            }
            answer.append("\n");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
