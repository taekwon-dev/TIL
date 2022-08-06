package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  점프
 *
 *  - N X N 게임판
 *  - 가장 왼쪽 위 칸 to 가장 오른쪽 아래 칸
 *  - 각 칸에 적혀있는 수는 현재 칸에서 갈 수 있는 거리를 의미한다
 *  - 반드시 오른쪽이나 아래쪽으로만 이동해야 한다
 *
 *  - 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 이동할 수 있는 경로의 개수
 *
 *  - 칸에 적혀있는 수는 0보다 크거나 같고, 9보다 작거나 같은 정수이며,
 *  - 가장 오른쪽 아래 칸에는 항상 0이 주어진다.
 *
 *  [1][2][1][1]  - 1
 *  [1][2][3][3]  - 2
 *  [1][3][2][1]  - 3
 *  [3][1][2][0]  - 4
 *   |  |  |  |
 *   1  2  3  4
 *
 *   (3,2)에 도달할 수 있는 경우의
 *
 *   [0][0][0][0]
 *   [0][0][0][0]
 *   [0][0][0][0]
 *   [0][0][0][0]
 *
 *   BU 방식으로 생각해보면,
 *
 *   dp[i][j] = 1,1 에서 i,j 까지 규칙을 따라 이동할 수 있는 경우의 수
 *   1,1 부터 규칙에 따라서 해당 위치에 도달하는 경우 + 1 처리하면 그 위치에 도달하는 경우의 수를 모두 구할 수 있다.
 *
 *   경로의 개수는 2^63-1보다 작거나 같다.
 *   2^63 ... long (8 byte)
 *
 *
 */
public class BOJ_1890 {
    static int n;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        dp = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == n && j == n) {
                    break;
                }
                int next = map[i][j];

                // →
                if (j + next <= n) dp[i][j + next] += dp[i][j];

                // ↓
                if (i + next <= n) dp[i + next][j] += dp[i][j];
            }
        }
        System.out.println(dp[n][n]);
    }
}
