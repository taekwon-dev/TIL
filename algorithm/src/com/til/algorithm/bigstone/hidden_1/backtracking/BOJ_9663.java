package com.til.algorithm.bigstone.hidden_1.backtracking;

import java.io.*;

public class BOJ_9663 {

    private static int N;
    private static int[] queens;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        queens = new int[N];
        backtracking(0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth) {
        if (depth == N) {
            // N개의 퀸을 착수할 수 있을 때, 카운트
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            queens[depth] = i;
            if (isLocatable(depth)) {
                backtracking(depth + 1);
            }
        }
    }

    private static boolean isLocatable(int row) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == queens[row]) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(queens[row] - queens[i])) {
                return false;
            }
        }
        return true;
    }
}