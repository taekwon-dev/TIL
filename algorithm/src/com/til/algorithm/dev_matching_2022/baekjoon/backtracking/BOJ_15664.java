package com.til.algorithm.dev_matching_2022.baekjoon.backtracking;

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
    static int[] nums;
    static int[] results;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

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

        int prev = 0;
        for (int i = index; i <= n; i++) {
            if (prev != nums[i]) {
                nums[count] = nums[i];
                prev = nums[i];
                backtracking(i + 1, index + 1);
            }
        }
    }

}
