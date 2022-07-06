package com.til.algorithm.programmers.kit.dfsbfs;

public class LV2_타겟넘버 {

    /**
     *  numbers.length -> 2 ~ 20
     *  완전탐색
     *  주어진 수가 N 개인 경우, + or - 를 N - 1 개 채워야 한다.
     *  이 때 각 위치 별로 + or - 2^(n-1) 만큼 경우의 수가 나온다.
     *
     *  최대 개수 20을 가정하면, 2^19 = 2^10 * 2^9 = 1024 * 512 = 약 500,000
     *
     *  https://www.acmicpc.net/problem/1182 (부분수열의 합) = 유사 문제
     */
    public int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer += 1;
            }
            return;
        }
        dfs(numbers, target, depth + 1, sum + numbers[depth]);
        dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }
}
