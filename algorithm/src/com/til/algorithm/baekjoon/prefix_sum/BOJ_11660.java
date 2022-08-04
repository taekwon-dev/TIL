package com.til.algorithm.baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  구간 합 구하기 5
 *
 *  DP + 누적 합
 *
 *  N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오
 *  (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000) 조건이므로
 *
 int sum = 0;
 for (int x = x1; x <= x2; x++) {
     for (int y = y1; y <= y2; y++) {
         sum += map[x][y];
     }
 }

 위 처럼 풀면 시간 초과

 https://subbak2.tistory.com/65

 DP 관점

 1) dp[i][j] = i, j 까지의 구간 합 (0,0) ~ (i,j) 점화식 구하기
 2) 위 점화식 활용해서 문제에서 원하는 영역 구하기
 *
 *
 */
public class BOJ_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1) dp 점화식
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + map[i][j];
            }
        }

        // 2) 문제 조건
        for (int i = 0; i < m; i++) {
            int prefixSum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            prefixSum += dp[x2][y2] + dp[x1 - 1][y1 - 1] - dp[x2][y1 - 1] - dp[x1 - 1][y2];
            System.out.println(prefixSum);
        }
    }

}
