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

        // 최대 길이가 N인 경우에 N을 반환하기 위해 N보다 1큰 수로 초기화
        int len = N + 1;
        int sum = 0;
        int j = 0;
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

        if (len == N + 1) {
            bw.write(0 + "\n");
        } else {
            bw.write(len + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}