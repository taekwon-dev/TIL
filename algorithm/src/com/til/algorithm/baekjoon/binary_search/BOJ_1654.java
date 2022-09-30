package com.til.algorithm.baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
    static int k;
    static long n;
    static int[] arr;
    static long max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Long.parseLong(st.nextToken());
        arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long s  = 1;
        long e = max;
        while (s <= e) {
            long mid = (s + e) / 2;
            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += (arr[i] / mid);
            }
            if (sum >= n) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(e);
    }
}
