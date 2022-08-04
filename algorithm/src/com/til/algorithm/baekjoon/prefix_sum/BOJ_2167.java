package com.til.algorithm.baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  2차원 배열의 합
 *
 *  2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오.
 *  배열의 (i, j) 위치는 i행 j열을 나타낸다.
 *
 *
 *  1 1 2 3 -> (1, 1) to (2, 3) 까지의 구간 합
 *  1 2 1 2 -> (1, 2) to (1, 2) 까지의 구간 합
 *  1 3 2 3 -> (1, 3) to (2, 3) 까지의 구간 합
 */
public class BOJ_2167 {
    static int n, m;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            System.out.println(prefixSum(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            ));
        }
    }

    private static int prefixSum(int sx, int sy, int ex, int ey) {
        int sum = 0;
        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j <= ey; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }
}
