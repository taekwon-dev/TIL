package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * 1) 28, 31번
 * 2) 24번
 *
 */
public class LEET_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtracking(answer, new ArrayList<>(), nums);
        return answer;
    }

    private void backtracking(List<List<Integer>> answer, List<Integer> arr, int[] nums) {
        if (arr.size() == nums.length) {
            answer.add(new ArrayList<>(arr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (arr.contains((Integer) nums[i])) continue;
            arr.add(nums[i]);
            backtracking(answer, arr, nums);
            arr.remove((Integer) nums[i]);
        }
    }
}
