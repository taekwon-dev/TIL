package com.til.algorithm.baekjoon.backtracking;

import java.io.*;

public class BOJ_10974 {

    private static int N;
    private static boolean[] visited;
    private static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        answer = new StringBuilder();

        backtracking(0, "");

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, String permutation) {
        if (depth == N) {
            answer.append(permutation).append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, permutation + i + " ");
                visited[i] = false;
            }
        }
    }
}