package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  차이를 최대로
 */
public class BOJ_10819 {
    static int n, max = 0;
    static int[] arr;
    static int[] rarr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        rarr = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0);
        System.out.println(max);
    }

    private static void backtracking(int depth) {
        if (depth == n) {
            // n - 1 개의 숫자를 모두 배치한 뒤
            // 수식 최댓값 계산
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(rarr[i] - rarr[i + 1]);
            }
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                rarr[depth] = arr[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }

}
