package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

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
        // 행을 기준으로 생각했을 때, 각 행에 하나의 퀸을 놓는 과정이 반복되어 결국 마지막 행에 도달할 수 있다면,
        // 문제 조건에 부합하는 케이스임을 생각할 수 있다.
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
        for (int i = 0; i < row; i++) {
            if (queen[row] == queen[i]) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(queen[row] - queen[i])) {
                return false;
            }
        }
        return true;
    }
}