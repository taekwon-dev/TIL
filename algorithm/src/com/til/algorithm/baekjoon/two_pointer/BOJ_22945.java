package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_22945 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] stat = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            stat[i] = Integer.parseInt(st.nextToken());
        }

        int l = 1;
        int r = N;
        int max = 0;
        while (l <= r) {
            int sum = Math.min(stat[l], stat[r]) * (r - l - 1);
            max = Math.max(max, sum);

            if (stat[l] > stat[r]) {
                r--;
            } else{
                l++;
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}