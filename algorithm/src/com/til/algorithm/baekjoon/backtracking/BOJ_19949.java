package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19949 {

    private static int result;
    private static int[] answer = new int[10];
    private static int[] selected = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0);
        System.out.println(result);
    }

    private static void backtracking(int depth) {
        if (depth == 10) {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                if (answer[i] == selected[i]) {
                    sum++;
                }
            }
            if (sum >= 5) {
                result++;
            }
            return;
        }
        for (int i = 1; i <= 5; i++) {
            if (depth > 1 && selected[depth - 1] == i && selected[depth - 2] == i) {
                continue;
            }
            selected[depth] = i;
            backtracking(depth + 1);
        }
    }
}
