package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9024 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int answer = 0;
            int min = Integer.MAX_VALUE;
            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                int sum = arr[left] + arr[right];
                int gap = Math.abs(K - sum);
                if (min >= gap) {
                    if (min > gap) {
                        answer = 0;
                    }
                    min = gap;
                    answer++;
                }
                if (sum >= K) {
                    right--;
                } else {
                    left++;
                }
            }
            bw.write(answer + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}