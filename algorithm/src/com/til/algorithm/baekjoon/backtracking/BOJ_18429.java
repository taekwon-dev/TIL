package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429 {

    private static int n;
    private static int k;
    private static boolean[] visited;
    private static int[] weights;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        weights = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, 500);
        System.out.println(answer);
    }

    private static void backtracking(int depth, int weight) {
        if (depth == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && (weight - k + weights[i]) >= 500) {
                visited[i] = true;
                backtracking(depth + 1, weight - k + weights[i]);
                visited[i] = false;
            }
        }
    }
}
