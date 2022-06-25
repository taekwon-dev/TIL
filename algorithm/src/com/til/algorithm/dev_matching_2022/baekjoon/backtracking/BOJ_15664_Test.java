package com.til.algorithm.dev_matching_2022.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/25.
 * Title : N과 M (10) (https://www.acmicpc.net/problem/15664)
 * Hint  :
 */
public class BOJ_15664_Test {

    static int n, m;
    static int[] nums = {0, 1, 7, 9, 9};
    static int[] results;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        n = 4;
        m = 2;
        results = new int[m];

        backtracking(1, 0);
        System.out.println(sb);
    }

    private static void backtracking(int index, int count) {
        System.out.println(String.format("Backtraking index = %d , count = %d", index, count));

        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(results[i] + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        for (int i = index; i <= n; i++) {
            if (prev != nums[i]) {
                results[count] = nums[i];
                prev = nums[i];
                backtracking(i + 1, count + 1);
            }
        }
    }
}
