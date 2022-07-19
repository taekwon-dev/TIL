package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  N과 M (2)
 *
 *  자연수 N과 M이 주어졌을 때  (1 ≤ M ≤ N ≤ 8),
 *  아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *
 *  - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 *  - 고른 수열은 오름차순이어야 한다.
 *
 *  N -> 1, 2, 3, ... N 이므로
 *
 *  첫 번째 자리 인덱스보다 항상 두 번째 자리 인덱스가 커야 한다.
 *
 */
public class BOJ_15650 {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n + 1];

        backtracking(0, 1);
        System.out.println(sb.toString());
    }

    private static void backtracking(int depth, int index) {
        if (depth == m) {
            // 출력
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        // 첫 번째 자리 인덱스보다 항상 두 번째 자리 인덱스가 커야 한다.
        for (int i = index; i <= n; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                backtracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
