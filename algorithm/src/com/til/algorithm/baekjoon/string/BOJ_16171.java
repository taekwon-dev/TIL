package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_16171 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        String K = br.readLine();
        S = S.replaceAll("[0-9]", "");
        if (S.contains(K)) {
            bw.write("1");
        } else {
            bw.write("0");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}