package com.til.algorithm.baekjoon.two_pointer;

import java.io.*;

public class BOJ_2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int sum = 0;
        int j = 1;

        for (int i = 1; i <= N; i++) {
            while (j <= N && sum < N) {
                sum += j;
                j++;
            }
            if (sum == N) {
                answer++;
            }
            sum -= i;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
