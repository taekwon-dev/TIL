package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10025 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[1_000_000 + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int ice = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] = ice;
        }
        int sum = 0;
        for (int i = 0; i < 1 + 2 * K && i <= 1_000_000; i++) {
            sum += arr[i];
        }
        int max = sum;
        for (int i = 1 + 2 * K, j = 0; i <= 1_000_000; i++, j++) {
            sum -= arr[j];
            sum += arr[i];
            if (max < sum) {
                max = sum;
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}