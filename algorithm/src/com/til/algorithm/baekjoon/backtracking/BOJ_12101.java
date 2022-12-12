package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_12101 {

    private static int n;
    private static int k;
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        backtracking(0, "");
        if (k > list.size()) {
            System.out.println(-1);
            return;
        }
        System.out.println(list.get(k - 1));
    }

    private static void backtracking(int sum, String s) {
        if (sum > n) {
            return;
        }
        if (sum == n) {
            list.add(s.substring(0, s.length() - 1));
            return;
        }
        for (int i = 1; i <= 3; i++) {
            backtracking(sum + i, s + i + "+");
        }
    }
}