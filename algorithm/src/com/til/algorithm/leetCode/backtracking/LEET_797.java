package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * All Paths From Source to Target
 */
public class LEET_797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, answer);
        return answer;
    }

    private void dfs(int[][] graph, int depth, List<Integer> path, List<List<Integer>> answer) {
        if (depth == graph.length - 1) {
            answer.add(new ArrayList<>(path));
            return;
        }
        for (int adj : graph[depth]) {
            path.add(adj);
            dfs(graph, adj, path, answer);
            path.remove(path.size() - 1);
        }
    }
}
