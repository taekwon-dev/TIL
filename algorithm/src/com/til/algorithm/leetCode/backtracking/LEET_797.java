package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_797 {

    private List<List<Integer>> answer = new ArrayList<>();
    private List<Integer> candidate = new ArrayList<>();
    private boolean[] visited;
    private List<Integer>[] adjList;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        visited = new boolean[graph.length];
        adjList = new ArrayList[graph.length];
        for (int i = 0; i < graph.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int from = i;
                int to = graph[i][j];
                adjList[from].add(to);
            }
        }
        candidate.add(0);
        dfs(0);
        return answer;
    }

    private void dfs(int start) {
        visited[start] = true;
        if (start == visited.length - 1) {
            answer.add(new ArrayList<>(candidate));
            return;
        }
        for (int adj : adjList[start]) {
            if (visited[adj]) {
                continue;
            }
            visited[adj] = true;
            candidate.add(adj);
            dfs(adj);
            visited[adj] = false;
            candidate.remove(candidate.size() - 1);
        }
    }
}