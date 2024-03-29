package com.til.algorithm.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [[0, 1, 1], [1, 0, 1], [1, 1, 0]]
 */
public class 순열_동일원소포함_중복제거 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0};
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtracking(nums, result, list, visited, 0);
        System.out.println("result = " + result);
    }

    private static void backtracking(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] visited, int depth) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        int prev = -1;
        for (int i = 0; i < nums.length; i++) {
            // 정렬 상태에서, 이전 선택 원소와 동일한 경우 배제
            if (!visited[i] && prev != nums[i]) {
                prev = nums[i];
                list.add(nums[i]);
                visited[i] = true;
                backtracking(nums, result, list, visited, depth + 1);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}