package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
    static int n;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        backtracking(0);
        System.out.println(answer);
    }

    private static void backtracking(int depth) {
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (validated(depth)) {
                backtracking(depth + 1);
            }
        }
    }

    private static boolean validated(int row) {
        for (int i = 0; i < row; i++) {
            /**
             *  arr[row] = 현재 착수한 줄에 퀸 놓은 위치
             *  arr[i] = 0 ~ 현재 착수한 줄 바로 위 범위에서 퀸 놓은 위치
             *  세로 위치 확인
             */
            if (arr[row] == arr[i]) {
                return false;
            }
            /**
             *  대각선 위치 확인
             */
            else if (Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}