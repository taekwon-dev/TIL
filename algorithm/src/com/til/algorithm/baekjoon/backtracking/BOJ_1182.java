package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {

    static int n, s;
    static int[] arr;
    static int answer;

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
        backtracking(0, 0);
        // s = 0 인 경우, 공집합이 포함되는데,
        // 문제 조건에서 부분 집합(수열)의 크기가 양수 조건이므로
        // answer - 1
        if (s == 0) {
            System.out.println(answer - 1);
        } else {
            System.out.println(answer);
        }
    }

    private static void backtracking(int depth, int sum) {
        if (depth == n) {
            if (sum == s) answer++;
            return;
        }
        backtracking(depth + 1, sum);
        backtracking(depth + 1, sum + arr[depth]);
    }
}
