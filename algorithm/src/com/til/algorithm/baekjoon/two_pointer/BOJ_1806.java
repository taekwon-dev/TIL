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
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = 99_990;
        int j = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            while (j < N && sum < S) {
                sum += arr[j];
                j++;
            }
            if (sum >= S && len > j - i) {
                len = j - i;
            }
            sum -= arr[i];
        }

        if (len == 99_990) {
            bw.write(0 + "\n");
        } else {
            bw.write(len + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}