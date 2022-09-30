package com.til.algorithm.baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {
    static int n, m;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        int maxTH = 0;
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());
            arr[i] = h;
            maxTH = Math.max(maxTH, h);
        }
        binarySearch(0, maxTH);
        System.out.println(max);
    }

    private static void binarySearch(int s, int e) {
        if (s > e) return;
        int mid = (s + e) / 2;
        if (getSum(mid) >= m) {
            max = Math.max(max, mid);
            binarySearch(mid + 1, e);
        } else {
            binarySearch(s, mid - 1);
        }

    }

    private static long getSum(int height) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (arr[i] - height > 0 ? arr[i] - height : 0);
        }
        return sum;
    }
}
