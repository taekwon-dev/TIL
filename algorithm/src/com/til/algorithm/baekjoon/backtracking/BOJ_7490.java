package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7490 {

    private static int n;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            sb = new StringBuilder();
            n = Integer.parseInt(br.readLine());
            backtracking(0, 1, 1, 1, 0, "1");
            System.out.println(sb.toString());
        }
    }

    private static void backtracking(int depth, int curr, int num, int sign, int sum, String s) {
        if (depth == n - 1) {
            sum += num * sign;
            if (sum == 0) {
                sb.append(s).append("\n");
            }
            return;
        }
        backtracking(depth + 1, curr + 1, num * 10 + (curr + 1), sign, sum, s + " " + (curr + 1));
        backtracking(depth + 1, curr + 1, curr + 1, 1, sum + (num * sign), s + "+" + (curr + 1));
        backtracking(depth + 1, curr + 1, curr + 1, -1, sum + (num * sign), s + "-" + (curr + 1));
    }
}
