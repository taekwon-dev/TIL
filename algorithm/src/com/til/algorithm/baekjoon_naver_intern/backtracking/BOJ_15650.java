package com.til.algorithm.baekjoon_pack_mg.backtracking;

import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Youn on 2022/05/26.
 * Title : N과 M (2) (https://www.acmicpc.net/problem/15650)
 * Hint  : 각 수열이 오름차순
 */
public class BOJ_15650 {
    static int n, m;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[m];

        backtracking(1, 0);
    }

    private static void backtracking(int index, int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = index; i <= n; i++) {
                nums[count] = i;
                backtracking(i + 1, count + 1);
            }
        }
}
