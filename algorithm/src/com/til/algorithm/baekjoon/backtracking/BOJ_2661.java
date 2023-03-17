package com.til.algorithm.baekjoon.backtracking;

import java.io.*;

public class BOJ_2661 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        backtracking("");
    }

    private static void backtracking(String candidate) {
        if (candidate.length() == N) {
            System.out.println(candidate);
            System.exit(0);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (isGood(candidate + i)) {
                backtracking(candidate + i);
            }
        }
    }

    private static boolean isGood(String candidate) {
        for (int i = 1; i <= candidate.length() / 2; i++) {
            String former = candidate.substring(candidate.length() - i * 2, candidate.length() - i);
            String latter = candidate.substring(candidate.length() - i);
            if (former.equals(latter)) {
                return false;
            }
        }
        return true;
    }
}