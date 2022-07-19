package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  N과 M(4)
 *
 *  자연수 N과 M이 주어졌을 때  (1 ≤ M ≤ N ≤ 8)
 *  아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *
 *  - 1부터 N까지 자연수 중에서 M개를 고른 수열
 *  - 같은 수를 여러 번 골라도 된다.
 *  - 고른 수열은 비내림차순이어야 한다.
 *
 *  1, 2, 3, 4 중 2
 *
 *  1 1
 *  1 2
 *  1 3
 *  1 4
 *  2 1 (X)
 *  2 2
 *  2 3
 *  2 4
 *  3 1 (X)
 *  3 2 (X)
 *  3 3
 *  3 4
 *  4 1 (X)
 *  4 2 (X)
 *  4 3 (X)
 *  4 4
 *
 *  첫 번째 자리 인덱스를 기준으로 같은 인덱스 또는 해당 인덱스보다 큰 위치에서 골라야 한다.
 */
public class BOJ_15652 {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        backtracking(0, 1);
        System.out.println(sb.toString());
    }

    private static void backtracking(int depth, int index) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = index; i <= n; i++) {
            arr[depth] = i;
            backtracking(depth + 1, i);
        }
    }
}
