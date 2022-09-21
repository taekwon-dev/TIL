package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수들의 합
 * <p>
 * 서로 다른 N개의 자연수의 합이 S라고 한다.
 * S를 알 때, 자연수 N의 최댓값은 얼마일까?
 * <p>
 * N = 자연수의 개수
 * S를 구성하는 N을 최대로 가지려면, 결국 작은 수부터 채워야 한다. -> Greedy
 * <p>
 * S = 10
 * <p>
 * 9 + 1 -> N = 2
 * 8 + 2 -> N = 2
 * 7 + 3 -> N = 2
 * .
 * .
 * .
 * 1 + 2 + 3 + 4 -> N = 4 (4보다 N을 크게 가질 수 없다)
 * <p>
 * 1 + 2 + 3 + 4 + 5
 */
public class BOJ_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        int answer = 0;
        int num = 0;
        long sum = 0;

        while (sum <= s) {
            sum += ++num;
            answer++;
        }
        System.out.println(sum == s ? answer : answer - 1);
    }
}
