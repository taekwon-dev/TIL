package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEET_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> pm = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, results, pm, visited, 0);
        return results;
    }

    private void backtracking(int[] nums, List<List<Integer>> results, List<Integer> pm, boolean[] visited, int depth) {
        if (depth == nums.length) {
            results.add(new ArrayList<>(pm));
            return;
        }
        int prev = -11;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i] && prev != nums[i]) {
                visited[i] = true;
                prev = nums[i];
                pm.add(nums[i]);
                backtracking(nums, results, pm, visited, depth + 1);
                pm.remove(pm.size() - 1);
                visited[i] = false;
            }
        }
    }
}
