package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] idx = new int[N];
        for (int i = 0; i < N; i++) {
            Arrays.sort(map[i]);
        }
        int answer = Integer.MAX_VALUE;
        while (true) {
            int min = map[0][idx[0]];
            int max = map[0][idx[0]];
            int minIdx = 0;
            for (int i = 1; i < N; i++) {
                if (min > map[i][idx[i]]) {
                    min = map[i][idx[i]];
                    minIdx = i;
                }
                if (max < map[i][idx[i]]) {
                    max = map[i][idx[i]];
                }
            }
            if (answer > max - min) {
                answer = max - min;
            }
            if (++idx[minIdx] >= M) {
                minIdx++;
                break;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}