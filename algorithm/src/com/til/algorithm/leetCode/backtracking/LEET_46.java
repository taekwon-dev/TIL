package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        List<Integer> pm = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, visited, results, pm, 0);
        return results;
    }

    private void backtracking(int[] nums, boolean[] visited, List<List<Integer>> results, List<Integer> pm, int depth) {
        if (depth == nums.length) {
            results.add(new ArrayList<>(pm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                pm.add(nums[i]);
                backtracking(nums, visited, results, pm, depth + 1);
                pm.remove(pm.size() - 1);
                visited[i] = false;
            }
        }
    }
}
