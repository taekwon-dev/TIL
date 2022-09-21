package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 동전
 * <p>
 * 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
 * <p>
 * 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다.
 * <p>
 * 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
 * <p>
 * (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
 * <p>
 * N = 동전 종류 K = 만들어야 할 돈
 * <p>
 * 동전 개수를 최소화 -> 사용할 수 있는 돈 중 큰 단위를 사용해야 한다.
 * <p>
 * N = 10, K = 4200
 * 1
 * 5
 * 10
 * 50
 * 100
 * 500
 * 1000
 * 5000
 * 10000
 * 50000
 * <p>
 * K = 4200 이므로, K 보다 큰 단위를 사용할 수 없다.
 * 1
 * 5
 * 10
 * 100
 * 500
 * 1000
 * <p>
 * 가장 큰 단위인 1000을 4번 사용 -> 4000 / 200
 * 200보다 큰 500은 사용할 수 없다.
 * 남은 단위 중 가장 큰 단위인 100을 2번 사용 -> 200 / 0
 * <p>
 * 따라서 6개로 구성할 수 있다.
 */
public class BOJ_11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (coins[i] <= k) {
                answer += (k / coins[i]);
                k %= coins[i];
            }
        }
        System.out.println(answer);
    }
}
