package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13908 {

    private static int N;
    private static int M;
    private static boolean[] visited = new boolean[10];
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                visited[Integer.parseInt(st.nextToken())] = true;
            }
        }
        backtracking(0, 0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int cnt) {
        if (depth == N) {
            if (cnt == M) {
                answer++;
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                backtracking(depth + 1, cnt);
            } else {
                visited[i] = false;
                backtracking(depth + 1, cnt + 1);
                visited[i] = true;
            }
        }
    }
}