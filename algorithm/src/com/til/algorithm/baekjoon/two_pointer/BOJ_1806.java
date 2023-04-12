package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int sum = 0;
        while (l <= N && r <= N) {
            if (sum >= S && len > r - l) {
                len = r - l;
            }
            if (sum < S) {
                sum += arr[r];
                r++;
            } else {
                sum -= arr[l];
                l++;
            }
        }
        if (len == Integer.MAX_VALUE) {
            bw.write(0 + "\n");
        } else {
            bw.write(len + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}