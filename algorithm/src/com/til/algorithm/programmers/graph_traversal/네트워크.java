package com.til.algorithm.programmers.graph_traversal;

/**
 * Created by Youn on 2022/05/09.
 * Title : 네트워크 (https://programmers.co.kr/learn/courses/30/lessons/43162)
 * Hint  : L3, 인접 행렬, 영역 구하기, DFS
 */
public class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int start, boolean[] visited, int[][] computers) {
        visited[start] = true;
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[start][i] == 1) {
                dfs(i, visited, computers);
            }
        }
    }
}
