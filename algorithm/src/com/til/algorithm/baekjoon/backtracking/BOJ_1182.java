package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  부분수열의 합
 */

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
        if (s == 0) {
            System.out.println(answer - 1);
        } else {
            System.out.println(answer);
        }
    }

    private static void backtracking(int depth, int sum) {
        if (depth == n) {
            if (sum == s) {
                answer++;
            }
            return;
        }
        backtracking(depth + 1, sum + arr[depth]);
        backtracking(depth + 1, sum);
    }
}
