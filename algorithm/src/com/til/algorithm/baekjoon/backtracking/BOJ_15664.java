package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  N과 M (10)
 *  N개의 자연수는 모든 다른 수가 아닐 수 있다. (-> 중복된 수가 있을 수 있다)
 *
 *  - 비내림 차순
 */
public class BOJ_15664 {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        answer = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backtracking(0, 0);
        System.out.println(sb.toString());
    }

    private static void backtracking(int depth, int index) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }
        int prev = 0;
        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                if (prev != arr[i]) {
                    prev = arr[i];
                    visited[i] = true;
                    answer[depth] = arr[i];
                    backtracking(depth + 1, i + 1);
                    visited[i] = false;
                }
            }
        }

    }
}
