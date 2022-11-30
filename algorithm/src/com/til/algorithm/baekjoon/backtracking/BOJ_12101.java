package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12101 {

    private static int n;
    private static int k;
    private static String answer = "-1";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        backtracking(0, "");
        if (answer.equals("-1")) {
            System.out.println(answer);
            return;
        }
        answer = answer.replace(" ", "+");
        System.out.println(answer.substring(0, answer.length() - 1));
    }

    private static void backtracking(int sum, String s) {
        if (sum > n) {
            return;
        }
        if (sum == n) {
            k--;
            if (k == 0) {
                answer = s;
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            backtracking(sum + i, s + i + " ");
        }
    }
}
