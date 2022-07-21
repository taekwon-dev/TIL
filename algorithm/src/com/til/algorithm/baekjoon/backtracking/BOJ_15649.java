package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  N과 M (1)
 *
 *  자연수 N과 M이 주어졌을 때,
 *  아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *
 *  첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
 *
 *  N M
 *  4 2
 *
 *  1 2
 *  1 3
 *  1 4
 *
 *  2 1
 *  2 3
 *  2 4
 *
 *  3 1
 *  3 2
 *  3 4
 *
 *  4 1
 *  4 2
 *  4 3
 *
 *  12
 *
 *  4P2 → 1 2 를 2 1 서로 다르게 봄
 *
 */

public class BOJ_15649 {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        visited = new boolean[n + 1];

        backtracking(0);
        System.out.println(sb.toString());
    }

    private static void backtracking(int depth) {
        if (depth == m) {
            // 출력
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
