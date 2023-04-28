package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6603 {

    private static int K;
    private static int[] arr;
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
            arr = new int[K];
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            backtracking(0, 0, "");
            answer.append("\n");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int start, String s) {
        if (depth == 6) {
            answer.append(s).append("\n");
            return;
        }
        for (int i = start; i < K; i++) {
            backtracking(depth + 1, i + 1, s + arr[i]);
        }
    }
}