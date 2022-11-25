package com.til.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14916 {

    private static final int CANNOT_MAKE_CHANGE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        if (n == 1) {
            System.out.println(CANNOT_MAKE_CHANGE);
            return;
        }

        while (n > 0) {
            if (n % 5 == 0) {
                answer += n / 5;
                break;
            } else {
                n -= 2;
                answer++;
            }
        }
        if (n < 0) {
            System.out.println(CANNOT_MAKE_CHANGE);
            return;
        }
        System.out.println(answer);
    }
}
