package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/26.
 * Title : N과 M (2) (https://www.acmicpc.net/problem/15650)
 * Hint  : 각 수열이 오름차순
 */
public class BOJ_15650 {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(1, 0);
    }

    private static void dfs(int curr, int index) {

        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = curr; i < n + 1; i++) {
            arr[index] = i;
            dfs(i + 1, index + 1);
        }
    }
}
