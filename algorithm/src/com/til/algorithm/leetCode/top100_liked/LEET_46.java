package com.til.algorithm.leetCode.top100_liked;

import java.util.ArrayList;
import java.util.List;

public class LEET_46 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> permutation = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int depth) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation.add(nums[i]);
                backtracking(nums, depth + 1);
                visited[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
