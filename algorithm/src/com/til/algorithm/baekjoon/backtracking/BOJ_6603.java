package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_6603 {

    private static int K;
    private static int[] S;
    private static int[] P;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) {
                break;
            }
            S = new int[K];
            P = new int[6];

            for (int i = 0; i < K; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            backtracking(0, 0);
            answer.append("\n");

        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int index) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                answer.append(P[i]).append(" ");
            }
            answer.append("\n");
            return;
        }
        for (int i = index; i < K; i++) {
            P[depth] = S[i];
            backtracking(depth + 1, i + 1);
        }
    }
}