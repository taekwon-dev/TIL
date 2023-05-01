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

        int i = 0;
        int j = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;

        while (j <= N) {
            if (sum >= S && len > j - i) {
                len = j - i;
            }
            if (sum < S) {
                sum += arr[j];
                j++;
            } else {
                sum -= arr[i];
                i++;
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