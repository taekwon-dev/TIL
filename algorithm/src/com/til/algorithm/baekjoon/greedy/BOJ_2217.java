package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(w);
        int max = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, w[i] * (n - i));
        }
        System.out.println(max);
    }
}
