package com.til.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_16922 {

    private static int n;
    private static int[] arr = {1, 5, 10, 50};
    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        backtracking(0, 0, 0);
        System.out.println(set.size());
    }

    private static void backtracking(int depth, int start, int num) {
        if (depth == n) {
            System.out.println("num = " + num);
            set.add(num);
            return;
        }
        for (int i = start; i < 4; i++) {
            backtracking(depth + 1, i, num + arr[i]);
        }
    }
}