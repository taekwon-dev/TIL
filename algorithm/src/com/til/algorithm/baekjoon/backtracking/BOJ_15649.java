package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/24.
 * Title : n과 m (1) (https://www.acmicpc.net/problem/15649)
 * Hint  :
 */
public class BOJ_15649 {
    static int n, m;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        arr = new int[m];

        dfs(0);
    }

    private static void dfs(int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                arr[index] = i;
                visited[i] = true;
                dfs(index + 1);
                visited[i] = false;
            }
        }
    }
}
