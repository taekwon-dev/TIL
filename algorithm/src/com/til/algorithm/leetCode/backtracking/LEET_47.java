package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEET_47 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> permutation = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int depth) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        int prev = -11;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i] && prev != nums[i]) {
                prev = nums[i];
                visited[i] = true;
                permutation.add(nums[i]);
                backtracking(nums, depth + 1);
                visited[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
