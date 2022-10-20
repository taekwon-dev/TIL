package com.til.algorithm.leetCode.backtracking;

public class LEET_526 {
    int result;
    public int countArrangement(int n) {
        int[] arr = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        backtracking(n, arr, visited, 1);
        return result;
    }

    private void backtracking(int n, int[] arr, boolean[] visited, int depth) {
        if (depth == n + 1) {
            result++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % depth == 0 || depth % i == 0)) {
                visited[i] = true;
                arr[depth] = i;
                backtracking(n, arr, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}
