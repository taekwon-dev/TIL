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

    private static void backtracking(int depth, int index, int sum) {
        if (depth == n) {
            set.add(sum);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            backtracking(depth + 1, i, sum + arr[i]);
        }
    }
}