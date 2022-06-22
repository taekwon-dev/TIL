package com.til.algorithm.baekjoon_naver_intern.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/24.
 * Title : n과 m (1) (https://www.acmicpc.net/problem/15649)
 * Hint  : 길이가 M인 수열을 모두 구하기 (1부터 N까지 자연수 중 중복 없이 M개를 고른 수열)
 */
public class BOJ_15649 {
    static int n, m;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[m];
        visited = new boolean[m];

        backtracking(0);
    }


    private static void backtracking(int count) {
        // 길이가 M인 수열
        if (count == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                nums[count] = i;
                visited[i] = true;
                backtracking(count + 1);
                visited[i] = false;
            }
        }
    }
}
