package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  1, 2, 3 더하기
 *
 *  정수 4를 1, 2, 3 의 합으로 나타내는 방법 7 가지
 *  4
 *  1 + 1 + 1 + 1
 *  1 + 1 + 2
 *  1 + 2 + 1
 *  2 + 1 + 1
 *  2 + 2
 *  1 + 3
 *  3 + 1
 */
public class BOJ_9095_TD {

    static int n, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            answer = 0;
            n = Integer.parseInt(br.readLine());
            td(0);
            System.out.println(answer);
        }
    }

    private static void td(int sum) {
        if (sum > n) return;
        if (sum == n) {
            answer++;
            return;
        }
        for (int i = 1; i <= 3; i++) {
            td(sum + i);
        }
    }
}
