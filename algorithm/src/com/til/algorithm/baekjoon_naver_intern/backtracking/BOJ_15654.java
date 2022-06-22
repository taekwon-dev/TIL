package com.til.algorithm.baekjoon_naver_intern.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * Created by Youn on 2022/05/26.
 * Title : N과 M (5) (https://www.acmicpc.net/problem/15654)
 * Hint  :
 */
public class BOJ_15654 {
    static int n, m;
    static int[] nums;
    static int[] results;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n + 1];
        visited = new boolean[n + 1];
        results = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        backtracking(0);
        System.out.println(sb);
    }

    private static void backtracking(int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(results[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                results[count] = nums[i];
                visited[i] = true;
                backtracking(count + 1);
                visited[i] = false;
            }
        }

    }
}
