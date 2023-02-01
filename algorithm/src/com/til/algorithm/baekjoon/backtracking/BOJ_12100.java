package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_12100 {

    private static int N;
    private static int[][] map;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 2;
        backtracking(0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth) {
        if (depth == 5) {
            max();
            return;
        }
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }
        for (int i = 0; i < 4; i++) {
            move(i);
            backtracking(depth + 1);
            for (int j = 0; j < N; j++) {
                map[j] = copy[j].clone();
            }
        }
    }

    private static void max() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (map[i][j] > answer) {
                    answer = map[i][j];
                }
            }
    }

    private static void move(int direction) {
        if (direction == 0) {
            // 위
            for (int i = 0; i < N; i++) {
                int idx = 0;
                int prev = 0;
                for (int j = 0; j < N; j++) {
                    if (map[j][i] != 0) {
                        if (prev == map[j][i]) {
                            map[idx - 1][i] = prev * 2;
                            prev = 0;
                            map[j][i] = 0;
                        } else {
                            prev = map[j][i];
                            map[j][i] = 0;
                            map[idx++][i] = prev;
                        }
                    }
                }
            }
        } else if (direction == 1) {
            // 아래
            for (int i = 0; i < N; i++) {
                int idx = N - 1;
                int prev = 0;
                for (int j = N - 1; j >= 0; j--) {
                    if (map[j][i] != 0) {
                        if (prev == map[j][i]) {
                            map[idx + 1][i] = prev * 2;
                            prev = 0;
                            map[j][i] = 0;
                        } else {
                            prev = map[j][i];
                            map[j][i] = 0;
                            map[idx--][i] = prev;
                        }
                    }
                }
            }
        } else if (direction == 2) {
            // 왼쪽
            for (int i = 0; i < N; i++) {
                int idx = 0;
                int prev = 0;
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != 0) {
                        if (prev == map[i][j]) {
                            map[i][idx - 1] = prev * 2;
                            prev = 0;
                            map[i][j] = 0;
                        } else {
                            prev = map[i][j];
                            map[i][j] = 0;
                            map[i][idx++] = prev;
                        }
                    }
                }
            }
        } else if (direction == 3) {
            // 오른쪽
            for (int i = 0; i < N; i++) {
                int idx = N - 1;
                int prev = 0;
                for (int j = N - 1; j >= 0; j--) {
                    if (map[i][j] != 0) {
                        if (prev == map[i][j]) {
                            map[i][idx + 1] = prev * 2;
                            prev = 0;
                            map[i][j] = 0;
                        } else {
                            prev = map[i][j];
                            map[i][j] = 0;
                            map[i][idx--] = prev;
                        }
                    }
                }
            }
        }
    }
}