package com.til.algorithm.leetCode.backtracking;

import java.util.HashSet;

public class LEET_1980 {

    private String result;

    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }
        backtracking(nums, set, 0, "");
        return result;
    }

    private void backtracking(String[] nums, HashSet<String> set, int depth, String str) {
        if (depth == nums.length) {
            if (!set.contains(str)) {
                result = str;
            }
            return;
        }
        for (int i = 0; i <= 1; i++) {
            backtracking(nums, set, depth + 1, str + i);
        }
    }
}
