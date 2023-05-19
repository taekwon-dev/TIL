package com.til.algorithm.leetCode.backtracking;

import java.util.HashSet;

public class LEET_1980 {

    private HashSet<String> set = new HashSet<>();
    private String answer;

    public String findDifferentBinaryString(String[] nums) {
        for (String num : nums) {
            set.add(num);
        }
        backtracking(nums.length, 0, "");
        return answer;
    }

    private void backtracking(int len, int depth, String candidate) {
        if (depth == len) {
            if (!set.contains(candidate)) {
                answer = candidate;
            }
            return;
        }
        backtracking(len, depth + 1, candidate + "0");
        backtracking(len, depth + 1, candidate + "1");
    }
}