package com.til.algorithm.baekjoon_naver_intern.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/06/17.
 * Title : 차이를 최대로 (https://www.acmicpc.net/problem/10819)
 * Hint  : Backtracking, Brute Force
 */
public class BOJ_10819 {
    static int n, result;
    static int[] nums;
    static int[] results;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n];
        results = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int count) {
        if (count == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(results[i] - results[i + 1]);
            }
            result = Math.max(result, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                results[count] = nums[i];
                visited[i] = true;
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }
}
