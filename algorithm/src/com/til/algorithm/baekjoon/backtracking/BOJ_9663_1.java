package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  N-Queen
 *
 *  N X N (2차원 배열)
 *
 *  같은 줄에 하나씩만 놓을 수 있다. (또는 같은 열에는 하나씩만 놓을 수 있다)
 *
 *  퀸을 착수하고, 착수한 시점에 그 다음 착수 위치를 찾기 전에 놓을 수 없는 곳을 미리 표기
 *
 */
public class BOJ_9663_1 {
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
            if (check(depth)) {
                backtracking(depth + 1);
            }
        }
    }

    private static boolean check(int col) {
        for (int i = 0; i < col; i++) {
            // 가로 방향
            if (arr[col] == arr[i]) {
                return false;
            }
            // 대각선 방향 (열의 차와 행의 차가 동일한 경우)
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
