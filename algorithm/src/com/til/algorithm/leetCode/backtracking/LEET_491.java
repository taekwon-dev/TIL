package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LEET_491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> results = new HashSet<>();
        if (nums == null || nums.length == 0) return new ArrayList<>(results);
        List<Integer> sub = new ArrayList<>();
        backtracking(nums, results, sub, 0);
        return new ArrayList<>(results);
    }

    private void backtracking(int[] nums, Set<List<Integer>> results, List<Integer> sub, int start) {
        if (sub.size() >= 2) results.add(new ArrayList<>(sub));
        for (int i = start; i < nums.length; i++) {

            if (sub.size() == 0 || sub.get(sub.size() - 1) <= nums[i]) {
                sub.add(nums[i]);
                backtracking(nums, results, sub, i + 1);
                sub.remove(sub.size() - 1);
            }
        }
    }
}
