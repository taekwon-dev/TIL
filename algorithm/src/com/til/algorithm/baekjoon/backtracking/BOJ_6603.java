package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6603 {

    private static int[] arr;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int K;
        while (true) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            if (K == 0) {
                break;
            }
            arr = new int[K];
            Arrays.sort(arr);

            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            backtracking(0, 0, "");
            answer.append("\n");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int start, String candidate) {
        if (depth == 6) {
            answer.append(candidate).append("\n");
            return;
        }
        for (int i = start; i < arr.length; i++) {
            backtracking(depth + 1, i + 1, candidate + arr[i] + " ");
        }
    }
}