package com.til.algorithm.baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int psum[] = new int[n + 1];
        psum[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            psum[i] = psum[i - 1] + arr[i];
        }

        long sum = 0;
        for (int i = 1; i <= n - 1; i++) {
            sum += arr[i] * (psum[n] - psum[i]);
        }
        System.out.println(sum);
    }
}