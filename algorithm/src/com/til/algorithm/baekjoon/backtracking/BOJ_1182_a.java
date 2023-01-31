package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  부분집합 + 조합
 */
public class BOJ_1182_a {

    private static int n;
    private static int s;
    private static int[] arr;
    private static int answer;

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
        backtracking(0, 0, 0);
        System.out.println(answer);
    }

    private static void backtracking(int depth, int index, int sum) {
        if (depth > 0 && sum == s) {
            answer++;
        }
        for (int i = index; i < n; i++) {
            backtracking(depth + 1, i + 1, sum + arr[i]);
        }
    }
}