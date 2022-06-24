package com.til.algorithm.dev_matching_2022.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/27.
 * Title : N과 M (9) (https://www.acmicpc.net/problem/15663)
 * Hint  : 1, 7, 9(3), 9(4) -> 1, 9(3) - 1, 9(4) 는 같은 수열로 판정
 *         주어진 수열에서 (1, 1) 안 되므로 방문 여부를 기록해야 함.
 */
public class BOJ_15663 {

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

    private static void backtracking(int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                sb.append(results[i] + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && prev != nums[i]) {
                visited[i] = true;
                results[index] = nums[i];
                prev = nums[i];
                backtracking(index + 1);
                visited[i] = false;
            }
        }
    }

}
