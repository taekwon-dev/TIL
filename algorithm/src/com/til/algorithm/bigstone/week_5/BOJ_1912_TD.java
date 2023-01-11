package com.til.algorithm.bigstone.week_5;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1912_TD {

    private static int[] arr;
    private static Integer[] dp;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new Integer[N];
        max = arr[0];
        dp[0] = arr[0];
        recurr(N - 1);
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int recurr(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(recurr(N - 1) + arr[N], arr[N]);
            max = Math.max(max, dp[N]);
        }
        return dp[N];
    }
}