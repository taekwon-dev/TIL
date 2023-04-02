package com.til.algorithm.baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringTokenizer st0 = new StringTokenizer(s, "0");
        StringTokenizer st1 = new StringTokenizer(s, "1");

        bw.write(Math.min(st0.countTokens(), st1.countTokens()) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}