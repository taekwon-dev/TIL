package com.til.algorithm.baekjoon.backtracking;

import java.io.*;

public class BOJ_9663 {

    private static int N;
    private static int[] queen;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        queen = new int[N];
        backtracking(0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int row) {
        if (row == N) {
            answer++;
            return;
        }
        for (int col = 0; col < N; col++) {
            queen[row] = col;
            if (isLocatable(row)) {
                backtracking(row + 1);
            }
        }
    }

    private static boolean isLocatable(int row) {
        for (int r = 0; r < row; r++) {
            if (queen[r] == queen[row]) {
                return false;
            }

            if (Math.abs(r - row) == Math.abs(queen[r] - queen[row])) {
                return false;
            }
        }
        return true;
    }
}