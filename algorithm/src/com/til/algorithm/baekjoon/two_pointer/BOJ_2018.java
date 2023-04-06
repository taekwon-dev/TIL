package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;

public class BOJ_2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 1;
        int sum = 1;
        int answer = 0;
        while (start <= end) {
            if (sum == N) {
                answer++;
            }
            if (sum < N) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}