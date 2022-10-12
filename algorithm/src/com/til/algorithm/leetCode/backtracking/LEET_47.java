package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEET_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, result, list, visited, 0);
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] visited, int depth) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        int prev = -11;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i] && prev != nums[i]) {
                visited[i] = true;
                prev = nums[i];
                list.add(nums[i]);
                backtracking(nums, result, list, visited, depth + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
