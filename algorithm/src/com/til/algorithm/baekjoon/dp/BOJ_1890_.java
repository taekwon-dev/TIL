package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890_ {
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
            dp[x][y] = Math.max(dp[x][y], dp[x][y] + dfs(nx, y));
        }

        if (ny <= n) {
            dp[x][y] = Math.max(dp[x][y], dp[x][y] + dfs(x, ny));
        }

        return dp[x][y];
    }
}
