package com.til.algorithm.baekjoon.greedy;

import java.io.*;

public class BOJ_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = Integer.MAX_VALUE;
        String[] minus = br.readLine().split("-");
        for (String s : minus) {
            String[] plus = s.split("\\+");
            int sum = 0;
            for (int i = 0; i < plus.length; i++) {
                sum += Integer.parseInt(plus[i]);
            }
            if (answer == Integer.MAX_VALUE) {
                answer = sum;
            } else {
                answer -= sum;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}