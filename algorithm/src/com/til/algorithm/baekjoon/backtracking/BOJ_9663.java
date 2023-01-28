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

    private static void backtracking(int depth) {
        if (depth == N) {
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            queen[depth] = i;
            if (isLocatable(depth)) {
                backtracking(depth + 1);
            }
        }
    }

    private static boolean isLocatable(int depth) {
        for (int row = 0; row < depth; row++) {
            if (queen[row] == queen[depth]) {
                return false;
            }
            if (Math.abs(depth - row) == Math.abs(queen[depth] - queen[row])) {
                return false;
            }
        }
        return true;
    }
}