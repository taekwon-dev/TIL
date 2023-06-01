package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = N - 1;
        int gap = Integer.MAX_VALUE;
        int sum = 0;
        int abs = 0;
        int answer = 0;

        while (i < j) {
            sum = arr[i] + arr[j];
            abs = Math.abs(sum);
            if (gap > abs) {
                gap = abs;
                answer = sum;
            }
            if (sum > 0) {
                j--;
            } else {
                i++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}