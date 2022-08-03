package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *   1로 만들기
 *
 *   사용할 수 있는 연산
 *
 *   - 3으로 나누어 떨어지면 3으로 나눈다.
 *   - 2로 나누어 떨어지면 2로 나눈다.
 *   - 1을 뺀다.
 *
 *   N -> 1
 *
 *   1 <= N <= 100,000 -> 1로 만들기
 *
 *   10 -> 5 -> 4 -> 2 -> 1 (2로 나누기 또는 1 빼기)
 *           ...  -> 3 -> 1
 * https://loosie.tistory.com/391
 *
 */
public class BOJ_1463 {
    static int n, min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        toOne(n, 0);
        System.out.println(min);
    }

    private static void toOne(int num, int cnt) {
        if (num == 1) {
            min = Math.min(min, cnt);
            return;
        }
        if (cnt >= min) return;
        if (num % 3 == 0) {
            toOne(num / 3, cnt + 1);
        }
        if (num % 2 == 0) {
            toOne(num / 2, cnt + 1);
        }
        toOne(num - 1, cnt + 1);
    }
    // d[1] = 0
    // d[2] = 1
    // d[3] = 1
    // d[4] = min(dp[3] + 1, dp[2] + 1) = 2
    // d[5] = dp[4] + 1 = 3

    // ex) 5 -> 4 -> 2 -> 1 (3)

    private static int toOneBu(int num) {
        int[] dp = new int[num + 1];
        // 명시 (초기화 때 이미 0)
        dp[1] = 0;
        for (int i = 2; i < num + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        return dp[num];
    }
}
