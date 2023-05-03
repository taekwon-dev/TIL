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
        int[] cnt = new int[100_001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int len = 0;
        int j = 0;
        for (int i = 0; i < N; i++) {
            while (j < N && cnt[arr[j]] < K) {
                cnt[arr[j]]++;
                j++;
            }
            len = Math.max(len, j - i);
            cnt[arr[i]]--;
        }

        bw.write(len + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}