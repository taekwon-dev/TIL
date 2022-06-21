package com.til.algorithm.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/18.
 * Title : 소수 찾기 (https://www.acmicpc.net/problem/1978)
 * Hint  :
 */
public class BOJ_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nums[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] prime = new boolean[10001];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= 1000; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 1000; j += i) {
                    prime[j] = false;
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (prime[nums[i]]) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}
