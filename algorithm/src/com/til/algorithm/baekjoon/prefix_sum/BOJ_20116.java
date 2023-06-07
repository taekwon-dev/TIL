package com.til.algorithm.baekjoon.prefix_sum;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20116 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        double[] sum = new double[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        boolean flag = false;
        int idx = 1;
        for (int i = N; i > 1; i--) {
            double x = (sum[N] - sum[i - 1]) / (N - i + 1);
            if (x <= arr[N - idx] - L || x >= arr[N - idx] + L) {
                flag = true;
                break;
            }
            idx++;
        }

        if (!flag) {
            bw.write("stable" + "\n");
        } else {
            bw.write("unstable" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}