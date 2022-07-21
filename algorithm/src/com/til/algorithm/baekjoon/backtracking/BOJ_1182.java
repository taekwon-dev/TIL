package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {

    /**
     *  부분수열의 합
     *
     *  한 집합의 원소가 N개
     *  부분집합
     *  - 공집합
     *  - 1개
     *  - 2개
     *  - .
     *  - .
     *  - N개
     *
     * ❗️ 문제 조건 = 부분 수열의 크기가 양수 (즉 공집합 제외) ❗️
     */
    static int n, s;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        if (s == 0) {
            // 타겟이 0인 경우, 공집합의 개수가 포함되므로 문제 조건에 따라 공집합을 제외하기 위해 -1 처리한다.
            System.out.println(answer - 1);
        } else {
            System.out.println(answer);
        }
    }

    private static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == s) {
                answer += 1;
            }
            return;
        }
        // 부분집합 { 0, 1, 2 }
        // ∅, {0}, {1}, {2}, {0, 1} ...
        // 각 자리에 대해서 선택 또는 미선택
        // 유사한 binary tree -> in order, post order, pre order traversal
        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
}
