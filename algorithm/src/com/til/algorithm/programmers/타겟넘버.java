package com.til.algorithm.programmers;

/**
 * Created by Youn on 2022/05/09.
 * Title : 타겟 넘버 (https://programmers.co.kr/learn/courses/30/lessons/43165)
 * Hint  : DFS 키워드, 타겟 넘버를 만들 때 주어진 모든 수를 활용하는 조건 (+ 각 수의 순서를 조작할 수 없음)
 */
public class 타겟넘버 {

    private int count = 0;

    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, 0, target, 0);
        answer = this.count;

        return answer;
    }

    private void dfs(int[] numbers, int depth, int target, int sum) {
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
