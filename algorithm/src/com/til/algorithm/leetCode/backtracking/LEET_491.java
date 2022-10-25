package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LEET_491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        backtracking(nums, set, list, 0);
        return new ArrayList<>(set);
    }

    private void backtracking(int[] nums, Set<List<Integer>> set, List<Integer> list, int index) {
        if (list.size() >= 2) {
            set.add(new ArrayList<>(list));
        }
        for (int i = index; i < nums.length; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                backtracking(nums, set, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
