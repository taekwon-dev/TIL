package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  점프
 *
 *  가장 왼쪽 위 칸 -> 가장 오른쪽 아래 칸
 *
 *  이동 방향 : 오른쪽, 아래쪽
 *
 *  가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 이동할 수 있는 경로의 개수 구하기
 *
 *  첫째 줄에 게임 판의 크기 N (4 ≤ N ≤ 100)
 *
 *  경로의 개수는 2^63 - 1 보다 작다.
 *
 *  2^63 : 9223372036854775808
 *  Java long : - 9223372036854775808  ~ 9223372036854775807
 *
 *  시작 점을 기준으로 이동할 수 있는 곳이 한정되어 있다.
 *
 *  맵의 범위 내 + 시작점의 이동할 값을 기준으로 그 다음 노드의 위치가 정해진다.
 *
 *  그 다음 노드도 마찬가지로 위와 같이 그 다음의 위치가 결정되는 구조다.
 *
 *  각 노드 별로 다음 노드로 이동할 떄 두 가지 경우의 수가 있다. (오른쪽, 아래쪽)
 *
 *  D[i, j] = D[i - ?, j - ?] + 1 (이전 위치에서 현재 위치 + 1)
 */
public class BOJ_1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];
        long[][] dp = new long[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int value = map[i][j];
                if (value == 0) {
                    break;
                }
                // 오른쪽
                if (j + value <= n) dp[i][j + value] += dp[i][j];
                // 아래쪽
                if (i + value <= n) dp[i + value][j] += dp[i][j];
            }
        }
        System.out.println(dp[n][n]);
    }
}
