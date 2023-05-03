package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2230 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (j < N) {
            if (arr[j] - arr[i] < M) {
                j++;
                continue;
            }
            if (arr[j] - arr[i] == M) {
                answer = M;
                break;
            }
            answer = Math.min(answer, arr[j] - arr[i]);
            i++;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}