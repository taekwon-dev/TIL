package com.til.algorithm.dev_matching_2022.baekjoon.backtracking;

/**
 * Created by Youn on 2022/05/27.
 * Title : N과 M (9) (https://www.acmicpc.net/problem/15663)
 * Hint  : 1, 7, 9(3), 9(4) -> 1, 9(3) - 1, 9(4) 는 같은 수열로 판정
 *         주어진 수열에서 (1, 1) 안 되므로 방문 여부를 기록해야 함.
 */
public class BOJ_15663_Test {

    static int n, m;
    static int[] nums = {0, 1, 7, 9, 9};
    static int[] results;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        n = 4;
        m = 2;
        results = new int[2];
        visited = new boolean[5];
        backtracking(0);
        System.out.println(sb);
    }

    private static void backtracking(int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(results[i] + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && prev != nums[i]) {
                visited[i] = true;
                results[index] = nums[i];
                prev = nums[i];
                backtracking(index + 1);
                visited[i] = false;
            }
        }
    }

}
