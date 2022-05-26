package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/26.
 * Title : N과 M (3) (https://www.acmicpc.net/problem/15651)
 * Hint  : 같은 수를 여러 번 고를 수 있다. (시간 초과 - StringBuilder 사용 후 통과)
 */
public class BOJ_15651 {

    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

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
            arr[index] = i;
            dfs(index + 1);
        }
    }
}
