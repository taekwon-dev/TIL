package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  거스름 돈
 */
public class BOJ_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        while (n > 0) {
            if (n % 5 == 0) {
                result += n / 5;
                break;
            }
            n -= 2;
            result++;
        }
        if (n < 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
