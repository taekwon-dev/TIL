package com.til.algorithm.baekjoon.backtracking;

import java.io.*;

public class BOJ_2661 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        backtracking("");
    }

    private static void backtracking(String s) {
        if (s.length() == N) {
            System.out.println(s);
            System.exit(0);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (isGood(s + i)) {
                backtracking(s + i);
            }
        }
    }

    private static boolean isGood(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            String former = s.substring(s.length() - i * 2, s.length() - i);
            String latter = s.substring(s.length() - i);
            if (former.equals(latter)) {
                return false;
            }
        }
        return true;
    }
}