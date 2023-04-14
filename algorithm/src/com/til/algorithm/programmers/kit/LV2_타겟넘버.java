package com.til.algorithm.programmers.kit;

public class LV2_타겟넘버 {

    private int[] numbers;
    private int target;
    private int answer;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        backtracking(0, 0);

        return answer;
    }

    private void backtracking(int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        backtracking(depth + 1, sum + numbers[depth]);
        backtracking(depth + 1, sum - numbers[depth]);
    }
}