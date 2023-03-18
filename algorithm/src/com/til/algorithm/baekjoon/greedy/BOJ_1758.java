package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Integer[] tip = new Integer[N];

        for (int i = 0; i < N; i++) {
            tip[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tip, Collections.reverseOrder());
        long answer = 0;
        int waitingNum = 1;
        for (int i = 0; i < tip.length; i++) {
            if (tip[i] - (waitingNum - 1) > 0) {
                answer += tip[i] - (waitingNum - 1);
            }
            waitingNum++;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}