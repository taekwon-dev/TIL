package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_46 {

    private List<List<Integer>> answer = new ArrayList<>();
    private List<Integer> candidate = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        backtracking(nums, 0);
        return answer;
    }

    private void backtracking(int[] nums, int depth) {
        if (depth == nums.length) {
            answer.add(new ArrayList<>(candidate));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                candidate.add(nums[i]);
                backtracking(nums, depth + 1);
                visited[i] = false;
                candidate.remove(candidate.size() - 1);
            }
        }
    }
}