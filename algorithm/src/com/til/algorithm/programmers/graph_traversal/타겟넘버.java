package com.til.algorithm.programmers.graph_traversal;

/**
 * Created by Youn on 2022/05/09.
 * Title : 타겟 넘버 (https://programmers.co.kr/learn/courses/30/lessons/43165)
 * Hint  : L2, 각 자리의 수를 더하거나 빼면서 타겟 넘버 만들기
 */
public class 타겟넘버 {

    int count = 0;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = this.count;
        return answer;
    }

    private void dfs(int[] numbers, int target, int sum, int depth) {
        if (depth == numbers.length) {
            if (target == sum) {
                count++;
            }
            return;
        }
        dfs(numbers, depth + 1, target, sum + numbers[depth]);
        dfs(numbers, depth + 1, target, sum - numbers[depth]);
    }


}
