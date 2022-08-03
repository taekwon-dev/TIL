package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  계단 오르기
 *  https://st-lab.tistory.com/132
 *
 *  계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다.
 *  각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.
 *
 *  [규칙]
 *  계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
 *  연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
 *  마지막 도착 계단은 반드시 밟아야 한다.
 *
 *  마지막 계단을 기준으로 생각하면, 이전 계단에서 오는 경우,
 *
 *  -> | 마지막 계단 |
 *
 *  -> -> | 마지막 계단 |
 *
 *  총 점수의 최댓값
 *
 *
 */
public class BOJ_2579 {
    static int n;
    static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        scores = new int[n + 1];
        // 각 계단을 밟았을 때 얻을 수 있는 점수 등록
        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        dp[1] = scores[1];
        dp[2] = scores[1] + scores[2]; // 각 계단을 밟았을 때 자연수 범위의 점수를 획득하므로
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + scores[i - 1], dp[i - 2]) + scores[i];
        }
        System.out.println(dp[n]);
    }
}
