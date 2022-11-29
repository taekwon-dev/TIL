package com.til.algorithm.algorithm.backtracking;

/**
 * true true false false
 * true false true false
 * true false false true
 * false true true false
 * false true false true
 * false false true true
 */
public class CombinationWithVisited {

    private static int n = 4;
    private static boolean[] visited = new boolean[4];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        backtracking(0, 0);
        System.out.println(sb.toString());
    }

    private static void backtracking(int depth, int start) {
        if (depth == n / 2) {
            for (int i = 0; i < visited.length; i++) {
                sb.append(visited[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
