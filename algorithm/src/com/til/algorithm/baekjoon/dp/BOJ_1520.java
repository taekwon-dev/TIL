package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  https://sihyungyou.github.io/baekjoon-1520/
 *  내리막 길
 *  DP + DFS
 *
 *  M X N 맵 (M과 N은 각각 500이하의 자연수이고, 각 지점의 높이는 10000이하의 자연수)
 *
 *  제일 왼쪽 위 칸 (= 현재 위치) to 제일 오른쪽 아래 칸 (= 타겟)
 *
 *  - 항상 높이가 더 낮은 지점으로만 이동하여 목표 지점까지 가고자 한다. -> 이동 방향 선택
 *  - 이동 (상하좌우 방향)
 *  - 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽 아래 지점까지 항상 내리막길로만 이동하는 경로의 개수를 구하는 프로그
 *
 *  하나의 위치에서 상, 하, 좌, 우 방향으로 이동할 수 있는데,
 *  높이가 더 낮은 지점으로 이동한다.
 *  이동 가능한 방향에서 높이 값이 최소이면서 같은 경우 -> 두 갈래로 나뉨
 *
 *  위 규칙을 따르면서 타겟 위치로 이동하는 경우의 수
 */
public class BOJ_1520 {
    static int m, n;
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
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }


        System.out.println(dfs(1, 1));
    }

    private static int dfs(int x, int y) {

        if (x == m && y == n) {
            // DFS 탐색 중,
            // 목표 위치 도달한 경우
            return 1;
        }

        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && ny >= 1 && nx <= m && ny <= n) {
                if (map[x][y] > map[nx][ny]) {
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }
        return dp[x][y];
    }
}
