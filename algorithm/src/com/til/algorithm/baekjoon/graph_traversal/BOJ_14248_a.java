package com.til.algorithm.baekjoon.graph_traversal;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14248_a {

    private static int N;
    private static int[] stone;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        stone = new int[N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
        }
        int start = Integer.parseInt(br.readLine());
        dfs(start);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int start) {
        if (start < 1 || start > N) {
            return;
        }
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        answer++;

        dfs(start - stone[start]);
        dfs(start + stone[start]);
    }
}