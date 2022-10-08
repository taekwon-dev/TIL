package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, result, list, 0);
        return result;
    }

    private void dfs(int[][] graph, List<List<Integer>> result, List<Integer> list, int start) {
        if (start == graph.length - 1) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int end : graph[start]) {
            list.add(end);
            dfs(graph, result, list, end);
            list.remove(list.size() - 1);
        }
    }
}
