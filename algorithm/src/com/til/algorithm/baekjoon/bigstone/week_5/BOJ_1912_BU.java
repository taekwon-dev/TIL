package com.til.algorithm.baekjoon.bigstone.week_5;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1912_BU {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N + 1];
        int max = arr[1];
        dp[1] = arr[1];
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}