package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10819 {

    private static int N;
    private static int[] arr;
    private static int[] tmp;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth) {
        if (depth == N) {
            answer = Math.max(answer, getMax());
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                tmp[depth] = arr[i];
                visited[i] = true;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int getMax() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(tmp[i] - tmp[i + 1]);
        }
        return sum;
    }
}