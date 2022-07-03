package com.til.algorithm.이코테.ch6_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Youn on 2022/05/13.
 * Title : 금광 (
 * Hint  : 무엇을 DP 테이블을 통해 관리할 것인가? → 이동할 수 있는 경우의 수 중 가장 많은 금을 갖고 있는 경우를 관리
 *         array[i][j] : i행 j열에 존재하는 금의 양
 *         dp[i][j] : i행 j열 까지의 최적의 해 (얻을 수 있는 금의 최댓값)
 *
 *         dp[i][j] = array[i][j] + max(dp[i - 1][j - 1], dp[i][j - 1], dp[i + 1][j - 1])
 *
 *         2열부터 각 노드 별로 최적의 해를 DP 테이블레 정리한 뒤 이동 가능한 범위 내에서 최댓값을 선택하면서 문제를 해결
 *
 *         dp 테이블 초기화 할 때 금광의 값이 1보다 큰 상태이므로 이차원 배열로 선언할 때 0으로 초기화된 것 그대로 활용
 *         (단, 1열은 그대로 초기화)
 *
 */
public class 금광 {

    static int T; // 테스크 케이스 수
    static int N; // 행
    static int M; // 열

    static int[][] map = new int[20][20];
    static int[][] dp = new int[20][20];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    map[n][m] = Integer.parseInt(st.nextToken());
                }
            }

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    dp[n][m] = map[n][m];
                }
            }

            // 열을 기준으로 행을 순회
            // dp[i][j] = array[i][j] + max(dp[i - 1][j - 1], dp[i][j - 1], dp[i + 1][j - 1])
            for (int m = 1; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    int left, leftUp, leftDown;

                    if (n == 0) leftUp = 0;
                    else leftUp = dp[n - 1][m - 1];

                    if (n == N-1) leftDown = 0;
                    else leftDown = dp[n + 1][m - 1];

                    left = dp[n][m - 1];
                    dp[n][m] = dp[n][m] + Math.max(leftUp, Math.max(leftDown, left));
                }
            }
            int result = 0;
            for (int n = 0; n < N; n++) {
                result = Math.max(result, dp[n][M - 1]);
            }
            System.out.println(result);



        }
    }
}
