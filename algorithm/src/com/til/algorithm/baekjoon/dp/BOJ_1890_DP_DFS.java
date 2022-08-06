package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  DP + DFS (TD)
 *  https://steady-coding.tistory.com/150
 */
public class BOJ_1890_DP_DFS {
    static int n;
    static int[][] map;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 0 으로 초기화되는 경우, 마지막 n, n 과 상태 표기가 겹치므로,
                // -1로 초기화
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(1, 1));
    }

    private static long dfs(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        if (x == n && y == n) {
            return 1;
        }

        dp[x][y] = 0;

        int nx = x + map[x][y];
        int ny = y + map[x][y];

        if (nx > n && ny > n) {
            return 0;
        }

        if (nx <= n) {
            dp[x][y] = Math.max(dp[x][y], dp[x][y] + dfs(x + map[x][y], y));
        }

        if (ny <= n) {
            dp[x][y] = Math.max(dp[x][y], dp[x][y] + dfs(x, y + map[x][y]));
        }

        return dp[x][y];
    }
}
