package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {

    private static int n;
    private static int[] queen;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queen = new int[n];
        backtracking(0);
        System.out.println(answer);
    }

    private static void backtracking(int depth) {
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            queen[depth] = i;
            if (isLocatable(depth)) {
                backtracking(depth + 1);
            }
        }
    }

    private static boolean isLocatable(int depth) {
        for (int i = 0; i < depth; i++) {
            if (queen[depth] == queen[i]) {
                return false;
            }
            if (Math.abs(depth - i) == Math.abs(queen[depth] - queen[i])) {
                return false;
            }
        }
        return true;
    }
}