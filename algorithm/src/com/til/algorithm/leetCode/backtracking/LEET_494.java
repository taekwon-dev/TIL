package com.til.algorithm.leetCode.backtracking;

public class LEET_494 {

    int answer;

    public int findTargetSumWays(int[] nums, int target) {
        backtracking(nums, target, 0, 0);
        return answer;
    }

    private void backtracking(int[] nums, int target, int depth, int sum) {
        if (depth == nums.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        backtracking(nums, target, depth + 1, sum + nums[depth]);
        backtracking(nums, target, depth + 1, sum - nums[depth]);
    }
}
