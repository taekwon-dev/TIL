package com.til.algorithm.programmers.extra.summer_winter_coding;

public class LV1_소수만들기 {

    private int answer;

    public int solution(int[] nums) {
        backtracking(nums, 0, 0, 0);
        return answer;
    }

    private void backtracking(int[] nums, int depth, int index, int sum) {
        if (depth == 3) {
            if (isPrimeNumber(sum)) {
                answer++;
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            backtracking(nums, depth + 1, i + 1, sum + nums[i]);
        }
    }

    private boolean isPrimeNumber(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}