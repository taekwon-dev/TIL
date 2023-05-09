package com.til.algorithm.baekjoon.greedy;

import java.io.*;

public class BOJ_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] minusSplit = br.readLine().split("-");

        int answer = 0;
        for (int i = 0; i < minusSplit.length; i++) {
            String[] plusSplit = minusSplit[i].split("\\+");
            int plus = 0;
            for (int j = 0; j < plusSplit.length; j++) {
                plus += Integer.parseInt(plusSplit[j]);
            }
            if (i == 0) {
                answer = plus;
                continue;
            }
            answer -= plus;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}