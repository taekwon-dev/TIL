package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;

public class BOJ_2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int left = 1;
        int right = 1;
        int sum = 1;

        while (left <= right) {
            if (sum == N) {
                answer++;
            }
            if (sum < N) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}