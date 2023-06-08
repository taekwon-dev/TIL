package com.til.algorithm.baekjoon.sort;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_5648 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[1_000_000];

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(sc.nextLong());
            sb.reverse();
            arr[i] = Long.parseLong(sb.toString());
        }

        Arrays.sort(arr, 0, N);

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}