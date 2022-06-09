package com.til.algorithm.baekjoon.two_pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/09.
 * Title : 수열 (https://www.acmicpc.net/problem/2559)
 * Hint  : 연속적인 며칠 동안의 온도의 합, 가장 큰 값
 */
public class BOJ_2559 {

    static int n, k;
    static int result = Integer.MIN_VALUE;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n - k; i++) {
            int intervalSum = 0;
            for (int j = i; j < i + k; j++) {
                intervalSum += nums[j];
            }
            result = Math.max(result, intervalSum);
        }
        System.out.println(result);
    }
}
