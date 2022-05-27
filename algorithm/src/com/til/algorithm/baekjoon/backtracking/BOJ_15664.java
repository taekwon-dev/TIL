package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/27.
 * Title : N과 M (10) (https://www.acmicpc.net/problem/15664)
 * Hint  :
 */
public class BOJ_15664 {
    static int n, m;
    static int[] arr;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        nums = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        dfs(1, 0);
        System.out.println(sb);
    }

    private static void dfs(int curr, int index) {

        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        for (int i = curr; i < n + 1; i++) {
            if (prev != nums[i]) {
                arr[index] = nums[i];
                prev = nums[i];
                dfs(i + 1, index + 1);
            }
        }
    }
}
