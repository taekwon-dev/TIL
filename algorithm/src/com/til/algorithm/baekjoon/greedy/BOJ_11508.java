package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_11508 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] costs = new Integer[n];
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(costs, Collections.reverseOrder());
        int result = 0;
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 3 == 0) continue;
            result += costs[i];
        }
        System.out.println(result);
    }
}
