package com.til.algorithm.algorithm.backtracking;


import java.util.ArrayList;
import java.util.List;

// {1, 2, 3, 4} 중 두 개 선택
// answer = [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
public class 조합 {

    static List<List<Integer>> answer = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        backtracking(nums, 0, 0);
        System.out.println("answer = " + answer);
    }

    private static void backtracking(int[] nums, int depth, int start) {
        if (depth == 2) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(nums, depth + 1, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
