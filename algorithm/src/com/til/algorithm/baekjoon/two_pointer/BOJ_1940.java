package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int answer = 0;
        int i = 0;
        int j = N - 1;
        int sum = 0;
        while (i < j) {
            sum = arr[i] + arr[j];
            if (sum < M) {
                i++;
                continue;
            }
            if (sum > M) {
                j--;
                continue;
            }
            answer++;
            i++;
            j--;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}