package com.til.algorithm.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  Subsets
 */
public class LEET_78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(nums, 0, answer, list);
        answer.add(new ArrayList<>());
        return answer;

    }
    private static void backtracking(int[] nums, int depth, List<List<Integer>> answer, List<Integer> list) {
        if (depth == nums.length) {
            return;
        }
        list.add(nums[depth]);
        answer.add(new ArrayList<>(list));
        backtracking(nums, depth + 1, answer, list);
        list.remove(list.size() - 1);
        backtracking(nums, depth + 1, answer, list);
    }

    public static void main(String[] args) {
        subsets(new int[]{1, 2});
    }
}
