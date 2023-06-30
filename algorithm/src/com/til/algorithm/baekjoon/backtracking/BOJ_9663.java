package com.til.algorithm.baekjoon.backtracking;

import java.io.*;

public class BOJ_9663 {

    private static int N;
    private static int[] arr;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
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
            arr[row] = col;
            if (isLocatable(row)) {
                backtracking(row + 1);
            }
        }
    }

    private static boolean isLocatable(int row) {
        for (int r = 0; r < row; r++) {
            if (arr[r] == arr[row]) {
                return false;
            }

            if (Math.abs(r - row) == Math.abs(arr[r] - arr[row])) {
                return false;
            }
        }
        return true;
    }
}