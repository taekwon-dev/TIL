package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LEET_78_b {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(nums, answer, list, 0);
        return answer;
    }

    private void backtracking(int[] nums, List<List<Integer>> answer, List<Integer> list, int depth) {
        if (depth == nums.length) {
            answer.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[depth]);
        backtracking(nums, answer, list, depth + 1);
        list.remove(list.size() - 1);

        backtracking(nums, answer, list, depth + 1);
    }
}
