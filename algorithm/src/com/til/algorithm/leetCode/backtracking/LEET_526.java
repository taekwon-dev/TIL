package com.til.algorithm.leetCode.backtracking;

public class LEET_526 {

    private int answer;
    private int[] candidate;
    private boolean[] visited;

    public int countArrangement(int n) {
        candidate = new int[n + 1];
        visited = new boolean[n + 1];
        backtracking(n, 1);
        return answer;
    }

    private void backtracking(int n, int depth) {
        if (depth == n + 1) {
            answer++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (depth % i == 0 || i % depth == 0)) {
                visited[i] = true;
                candidate[depth] = i;
                backtracking(n, depth + 1);
                visited[i] = false;
            }
        }
    }
}