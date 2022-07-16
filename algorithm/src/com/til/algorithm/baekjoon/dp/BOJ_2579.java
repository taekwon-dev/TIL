package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  계단 오르기
 *
 *  - 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다.
 *  - 연속된 세 개의 계단을 모두 밟아서는 안 된다.
 *  - 마지막 도착 계단은 반드시 밟아야 한다.
 *
 *  각 계단을 밟을 때 점수를 획득하는데, 받을 수 있는 점수의 최댓값
 *
 *  D[i] = i 번째 계단에 위치할 수 있는 경우의 수
 *
 *  D[1] = 1
 *  D[2] = 2
 *  .
 *  .
 *  .
 *  D[i] = ?
 *
 *  마지막 계단 (-> N) (= 목적지)를 기준으로 생각하면
 *
 *  N - 2 -> N (두 계단 이동)
 *  N - 1 -> N (한 계단 이동)
 *
 *  따라서, D[i] = D[i - 1] + D[i - 2] (i >= 3) 로 볼 수 있다.
 *
 *  D[3] = D[1] + D[2] = 3
 *
 *  D[1] = 1 => 1
 *  D[2] = 1 - 1, 2  => 2
 *  D[3] = 1 - 1 - 1, 1 - 2, 2 - 1 이 떄 조건에 의해 1 - 1 - 1 은 제외 처리 => 2
 *
 *  즉 각 케이스 별로 한 개만 제외 (1 - 1 - 1 - 1 - .... - 1)
 *
 *  -----
 *  근데 위 처럼 계산하면 각 점수를 트랙킹 하기 어려움.
 *
 *  D[i] = i 번째 계단에 도달하기 까지 얻을 수 있는 최대 점수로 재정의
 *
 *  마지막 계단(N)을 기준으로
 *
 *  N - 1 -> N (단 연속된 세 개의 계단을 모두 밟을 수 없으므로 N - 3 -> N - 1 -> N 이 경우로 한정)
 *  N - 2 -> N
 *
 *  D[n] = Max(dp[n-3] + score[n - 1], dp[n - 1]) + score[n]
 *
 *
 */
public class BOJ_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = scores[1];
        if (n >= 2) dp[2] = dp[1] + scores[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + scores[i - 1], dp[i - 2]) + scores[i];
        }
        System.out.println(dp[n]);
    }
}
