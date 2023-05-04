package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16987 {

    private static int N;
    private static int[][] arr;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        backtracking(0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int idx) {
        if (idx == N) {
            int egg = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i][0] <= 0) {
                    egg++;
                }
            }
            answer = Math.max(answer, egg);
            return;
        }
        if (arr[idx][0] <= 0) {
            backtracking(idx + 1);
        } else {
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (i == idx || arr[i][0] <= 0) {
                    continue;
                }
                flag = true;
                arr[i][0] -= arr[idx][1];
                arr[idx][0] -= arr[i][1];
                backtracking(idx + 1);
                arr[i][0] += arr[idx][1];
                arr[idx][0] += arr[i][1];
            }
            if (!flag) {
                backtracking(idx + 1);
            }
        }
    }
}