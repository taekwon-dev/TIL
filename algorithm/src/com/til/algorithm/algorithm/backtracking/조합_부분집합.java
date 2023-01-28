package com.til.algorithm.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class 조합_부분집합 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(nums, result, list, 0);

        // result = [[1, 2, 3], [1, 2], [1, 3], [1], [2, 3], [2], [3], []]
        System.out.println("result = " + result);
    }

    private static void backtracking(int[] nums, List<List<Integer>> result, List<Integer> list, int depth) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[depth]);
        backtracking(nums, result, list, depth + 1);
        list.remove(list.size() - 1);

        backtracking(nums, result, list, depth + 1);
    }
}
