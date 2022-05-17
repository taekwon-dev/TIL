package com.til.algorithm.baekjoon.disorder;

import java.util.Scanner;

/**
 * Created by Youn on 2022/05/17.
 * Title : 거스름돈 (https://www.acmicpc.net/problem/5585)
 * Hint  : 정당성 분석 (큰 단위가 항상 작은 단위의 배수이므로 작은 단위의 동전들을 종합해 다른 해가 나올 수 없다)
 *         (Greedy 알고리즘을 통해 최적의 해를 도출할 수 있는 구조)
 */
public class BOJ_5585 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int change = 1000 - sc.nextInt(); // 거스름 돈
        int count = 0;
        int[] coins = {500, 100, 50, 10, 5, 1};

        for (int coin : coins) {
            if (coin > change) {
                continue;
            }
            count += change / coin;
            change %= coin;
        }
        System.out.println(count);
    }

}
