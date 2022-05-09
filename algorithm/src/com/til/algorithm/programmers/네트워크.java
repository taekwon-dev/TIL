package com.til.algorithm.programmers;

/**
 * Created by Youn on 2022/05/09.
 * Title : 네트워크 (https://programmers.co.kr/learn/courses/30/lessons/43162)
 * Hint  :
 */
public class 네트워크 {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int[][] computers, boolean[] visited, int start) {
        visited[start] = true;
        for (int i = 0; i < computers.length; i++) {
            if (!visited[start] && computers[start][i] == 1) {
                dfs(computers, visited, i);
            }
        }
    }
}
