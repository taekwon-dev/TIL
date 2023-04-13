package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;

public class BOJ_2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int sum = 1;
        int i = 1;
        int j = 1;
        while (i <= j) {
            if (sum == N) {
                answer++;
            }
            if (sum < N) {
                j++;
                sum += j;
            } else {
                sum -= i;
                i++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}