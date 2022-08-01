package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  모든 순열
 *
 *  N이 주어졌을 때, N(1 ≤ N ≤ 8)
 *  1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.
 *
 *  8! = 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1 = 40320
 *
 *  순열 = 조합 + 순서 고려
 *
 *  3! = 3 * 2 * 1 =6
 *
 *  1 2 3
 *  1 3 2
 *  2 1 3
 *  2 3 1
 *  3 1 2
 *  3 2 1
 *
 *  같은 수를 중복해서 사용할 수 없다.
 *
 */
public class BOJ_10974 {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        backtracking(0);
        System.out.println(sb.toString());
    }

    private static void backtracking(int depth) {
        if (depth == n) {
            // 출력
            for (int i = 0; i < n; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }

    }


}
