package com.til.algorithm.baekjoon_naver_intern.backtracking;

import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Youn on 2022/05/27.
 * Title : N과 M (8) (https://www.acmicpc.net/problem/15657)
 * Hint  :
 */
public class BOJ_15657 {
    static int n, m;
    static int[] nums;
    static int[] results;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n + 1];
        results = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        backtracking(1, 0);
        System.out.println(sb);
    }

    private static void backtracking(int index, int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(results[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = index; i <= n; i++) {
            results[count] = nums[i];
            backtracking(i, count + 1);
        }
    }
}
