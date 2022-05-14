package com.til.algorithm.baekjoon.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/11.
 * Title : 내리막 길 (https://www.acmicpc.net/problem/1520)
 * Hint  : DFS + DP, DP 적용해야 하는 상황
 */
public class BOJ_1520 {
    static int m;
    static int n;

    static int[][] map;
    static int[][] dp;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m + 1][n + 1];
        dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(1, 1));


    }

    private static int dfs(int x, int y) {

        if (x == m && y == n) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        } else {
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    // 현재 좌표의 높이 값보다 작은 값을 갖고 있는 경우
                    if (map[m][n] > map[nx][ny]) {
                        dp[x][y] += dfs(nx, ny);
                    }
                }
            }
        }
        return dp[x][y];
    }
}
