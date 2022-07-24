package com.til.algorithm.baekjoon.backtracking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1, 2, 3 더하기 2
 *
 * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다.
 * 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
 *
 * 1 + 1 + 1 + 1
 * 1 + 1 + 2
 * 1 + 2 + 1
 * 2 + 1 + 1
 * 2 + 2
 * 1 + 3
 * 3 + 1
 *
 * 1 <= N < 11
 *
 *
 * 자리수 기준 X
 * 합 기준이 N 이 되는 조건
 *
 *
 *
 */
public class BOJ_12101 {
    static int n, k;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        backtracking(0, "");
        if (count < k) {
            System.out.println(-1);
        }
    }

    private static void backtracking(int sum, String answer) {
        if (sum > n) return;
        if (sum == n) {
            count++;
            if (count == k) {
                System.out.println(answer.substring(0, answer.length() - 1));
                System.exit(0);
            }

        }
        for (int i = 1; i <= 3; i++) {
            backtracking(sum + i, answer + i + "+");
        }
    }
}
