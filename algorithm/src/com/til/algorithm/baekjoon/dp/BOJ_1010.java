package com.til.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  다리 놓기
 *
 *  강 서쪽 (W) - N 개의 사이트
 *  강 동쪽 (E) - M 개의 사이트
 *
 *  0 < N <= M < 30
 *
 *  1:1 대응 (한 사이트에 두 개 이상의 다리가 연결될 수 없음)
 *  다리를 최대한 많이 지으려고 한다. -> N 개만큼 지으려고 한다.
 *  다리는 겹쳐질 수 없다.
 *  최대한 많은 다리를 지을 수 있는 경우의 수
 *
 *  결국 M 개의 사이트에서 N 개를 고르는 경우의 수와 동일하다. (이 때 선택된 M개의 사이트의 순서는 의미가 없다 -> 조합 Combination)
 *
 *  조합 성질
 *
 *  nCo = = nCn = 1
 *  n+1Cr+1 = nCr + nCr+1
 *
 *  3C2 (3) = 2C1 (2) + 2C2 (1) = 3
 */
public class BOJ_1010 {

    static int tc, n, m;
    static int[][] dp = new int[29 + 1][29 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            for (int i = 0; i < dp.length; i++) {
                dp[i][i] = 1;
                dp[i][0] = 1;
            }

            for (int i = 2; i < dp.length; i++) {
                for (int j = 1; j < dp.length; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
            System.out.println(dp[m][n]);
        }
    }
}
