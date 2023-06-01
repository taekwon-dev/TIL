package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9024 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        int N = 0;
        int K = 0;
        int[] arr;
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int answer = 1;
            int l = 0;
            int r = N - 1;
            int gap = Integer.MAX_VALUE;
            int sum = 0;
            int abs = 0;

            while (l < r) {
                sum = arr[l] + arr[r];
                abs = Math.abs(K - sum);
                if (gap > abs) {
                    answer = 1;
                    gap = abs;
                } else if (gap == abs) {
                    answer++;
                }
                if (sum < K) {
                    l++;
                } else {
                    r--;
                }
            }

            bw.write(answer + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}