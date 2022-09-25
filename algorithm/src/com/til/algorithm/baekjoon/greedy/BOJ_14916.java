package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        if (n == 1) {
            System.out.println(-1);
            return;
        }
        while (n > 0) {
            if (n % 5 == 0) {
                answer += n / 5;
                n = 0;
            } else {
                n -= 2;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
