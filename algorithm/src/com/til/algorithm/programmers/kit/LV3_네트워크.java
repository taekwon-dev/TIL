package com.til.algorithm.programmers.kit;

import java.util.ArrayList;

public class LV3_네트워크 {

    private ArrayList<Integer>[] adjList;
    private boolean[] visited;

    public int solution(int n, int[][] computers) {
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (computers[i][j] == 1) {
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }
        visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int start) {
        visited[start] = true;

        for (int adj : adjList[start]) {
            if (!visited[adj]) {
                dfs(adj);
            }
        }
    }
}