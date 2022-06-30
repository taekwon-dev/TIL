package com.til.algorithm.dev_matching_2022.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Youn on 2022/06/30.
 * Title : 모든 순열 (https://www.acmicpc.net/problem/10974)
 * Hint  :
 */
public class BOJ_10974 {
    /**
     *  [ 1, 2, 3]
     *
     *  1, 2, 3
     *  1, 3, 2
     *  2, 1, 3
     *  2, 3, 1
     *  3, 1, 2
     *  3, 2, 1
     *
     */

    static int n;
    static int[] nums;
    static int[] results;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        results = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backtracking(0);
        System.out.println(sb.toString());
    }

    private static void backtracking(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                sb.append(results[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                results[depth] = nums[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
