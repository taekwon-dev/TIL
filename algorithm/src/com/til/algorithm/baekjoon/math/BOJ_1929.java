package com.til.algorithm.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/18.
 * Title : 소수 구하기 (https://www.acmicpc.net/problem/1929)
 * Hint  : '에라토스테네스의 체'
 *         1 ~ 10 범위에서 소수 구하기
 *         위 범위에서 소수인 수의 제곱부터 배수를 모두 제거 (단, 소수의 제곱이 타겟보다 작거나 같은 경우까지만)
 *         4, 6, 8, 10 (제거)
 *         9 (제거)
 *         따라서, 2, 3, 5, 7
 */
public class BOJ_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] prime = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();

        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        for (int i = m; i <= n; i++) {
            if (prime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
