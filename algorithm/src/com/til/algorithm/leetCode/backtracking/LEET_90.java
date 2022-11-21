package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEET_90 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int depth) {
        result.add(new ArrayList<>(list));
        int prev = -11;
        for (int i = depth; i < nums.length; i++) {
            if (prev != nums[i]) {
                prev = nums[i];
                list.add(nums[i]);
                backtracking(nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
