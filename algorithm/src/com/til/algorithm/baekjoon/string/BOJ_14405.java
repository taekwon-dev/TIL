package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_14405 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        S = S.replace("pi", "");
        S = S.replace("ka", "");
        S = S.replace("chu", "");
        if (S.length() > 0) {
            bw.write("NO" + "\n");
        } else {
            bw.write("YES" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}