package com.til.algorithm.baekjoon.two_pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/09.
 * Title : 수들의 합 2 (https://www.acmicpc.net/problem/2003)
 * Hint  :
 */
public class BOJ_2003 {

    static int n, m, result;
    static int[] nums = new int[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0, intervalSum = 0;
        for (int start = 0; start < n; start++) {
            while (intervalSum < m && end < n) {
                intervalSum += nums[end];
                end += 1;
            }
            if (intervalSum == m) {
                result += 1;
            }
            intervalSum -= nums[start];
        }
        System.out.println(result);
    }
}
