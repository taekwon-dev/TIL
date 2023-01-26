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

    private static boolean isLocatable(int depth) {
        for (int i = 0; i < depth; i++) {
            // 현재 착수한 곳과 겹치는 곳이 있는 지 세로 방향으로 검사
            if (queens[depth] == queens[i]) {
                return false;
            }
            // 대각선 방향 (열의 차와 행의 차가 동일한 경우)
            if (Math.abs(depth - i) == Math.abs(queens[depth] - queens[i])) {
                return false;
            }
        }
        return true;
    }
}
