package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/26.
 * Title : N과 M (5) (https://www.acmicpc.net/problem/15654)
 * Hint  :
 */
public class BOJ_15654 {
    static int n, m;
    static int[] nums;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n + 1];
        visited = new boolean[n + 1];
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                arr[index] = nums[i];
                visited[i] = true;
                dfs(index + 1);
                visited[i] = false;
            }
        }
    }
}
