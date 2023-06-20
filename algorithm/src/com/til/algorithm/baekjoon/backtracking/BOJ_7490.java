package com.til.algorithm.baekjoon.backtracking;

import java.io.*;

public class BOJ_7490 {

    private static int N;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            N = Integer.parseInt(br.readLine());
            backtracking(1, 1, 0, 1, "1");
            answer.append("\n");
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int num, int sum, int op, String candidate) {
        if (depth == N) {
            sum += (num * op);
            if (sum == 0) {
                answer.append(candidate).append("\n");
            }
            return;
        }
        backtracking(depth + 1, num * 10 + (depth + 1), sum, op, candidate + " " + (depth + 1));
        backtracking(depth + 1, depth + 1, sum + (num * op), 1, candidate + "+" + (depth + 1));
        backtracking(depth + 1, depth + 1, sum + (num * op), -1, candidate + "-" + (depth + 1));
    }
}