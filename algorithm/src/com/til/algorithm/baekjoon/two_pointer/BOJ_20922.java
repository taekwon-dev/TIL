package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] count = new int[100_001];

        int len = 0;
        int j = 0;

        for (int i = 0; i < N; i++) {
            while (j < N && count[arr[j]] < K) {
                count[arr[j]]++;
                j++;
            }
            if (len < j - i) {
                len = j - i;
            }
            count[arr[i]]--;
        }

        bw.write(len + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}