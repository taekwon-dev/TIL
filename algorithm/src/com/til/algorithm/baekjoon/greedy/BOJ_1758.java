package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] tips = new Integer[n];
        for (int i = 0; i < n; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tips, Collections.reverseOrder());
        long result = 0;
        for (int i = 0; i < n; i++) {
            int pay = tips[i] - (i);
            if (pay > 0) result += pay;
        }
        System.out.println(result);
    }
}
