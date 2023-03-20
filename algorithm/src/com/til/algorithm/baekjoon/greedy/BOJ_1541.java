package com.til.algorithm.baekjoon.greedy;

import java.io.*;

public class BOJ_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int min = Integer.MAX_VALUE;
        String[] bundles = br.readLine().split("-");

        for (String bundle : bundles) {
            String[] s = bundle.split("\\+");
            int sum = 0;
            for (int i = 0; i < s.length; i++) {
                sum += Integer.parseInt(s[i]);
            }
            if (min == Integer.MAX_VALUE) {
                min = sum;
            } else {
                min -= sum;
            }
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}