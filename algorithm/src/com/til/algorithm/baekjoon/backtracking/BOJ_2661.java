package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2661 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        backtracking("");
    }

    private static void backtracking(String s) {
        if (s.length() == n) {
            System.out.println(s);
            System.exit(0);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (isGood(s + i)) backtracking(s + i);
        }
    }

    private static boolean isGood(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            String front = s.substring(s.length() - i * 2, s.length() - i);
            String back = s.substring(s.length() - i, s.length());
            if (front.equals(back)) return false;
        }
        return true;
    }
}