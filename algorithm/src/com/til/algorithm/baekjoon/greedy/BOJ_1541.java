package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");
        int min = Integer.MAX_VALUE;

        for (String s : str) {
            String[] p = s.split("\\+");
            int sum = 0;
            for (int i = 0; i < p.length; i++) {
                sum += Integer.parseInt(p[i]);
            }
            if (min == Integer.MAX_VALUE) {
                min = sum;
            } else {
                min -= sum;
            }
        }
        System.out.println(min);
    }
}
