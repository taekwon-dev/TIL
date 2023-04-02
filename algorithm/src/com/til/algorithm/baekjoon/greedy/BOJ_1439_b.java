package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1439_b {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int zero = 0;
        int one = 0;
        if (s.charAt(0) == '0') {
            zero++;
        } else {
            one++;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                if (s.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
        }

        bw.write(Math.min(zero, one) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}