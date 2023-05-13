package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += arr[i];
        }
        int max = sum;
        int maxCnt = 1;
        for (int i = X; i < N; i++) {
            sum += arr[i] - arr[i - X];
            if (max < sum) {
                max = sum;
                maxCnt = 1;
                continue;
            }
            if (max == sum) {
                maxCnt++;
            }
        }

        if (max == 0) {
            bw.write("SAD" + "\n");
        } else {
            bw.write(max + "\n");
            bw.write(maxCnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}