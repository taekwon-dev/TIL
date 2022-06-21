package com.til.algorithm.baekjoon_pack_mg.backtracking;

import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Youn on 2022/05/26.
 * Title : N과 M (4) (https://www.acmicpc.net/problem/15652)
 * Hint  : 비내림차순 (같은 수를 어떻게 처리할까?, 비내림차순 != 오름차순)
 */
public class BOJ_15652 {
    static int n, m;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[m];
        backtracking(1, 0);
        System.out.println(sb);
    }

    private static void backtracking(int index, int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(nums[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = index; i <= n; i++) {
            nums[count] = i;
            backtracking(i, count + 1);
        }
    }

}
