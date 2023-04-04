package com.til.algorithm.baekjoon.greedy;

import java.io.*;

public class BOJ_2847 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] point = new int[N];

        for (int i = 0; i < N; i++) {
            point[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;


        while (true) {
            boolean flag = true;
            for (int i = 0; i < N - 1; i++) {
                if (point[i] >= point[i + 1]) {
                    while (point[i] >= point[i + 1]) {
                        point[i]--;
                        answer++;
                    }
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}