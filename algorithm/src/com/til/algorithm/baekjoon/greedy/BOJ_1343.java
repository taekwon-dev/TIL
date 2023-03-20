package com.til.algorithm.baekjoon.greedy;

import java.io.*;

public class BOJ_1343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String target = br.readLine();
        target = target.replace("XXXX", "AAAA");
        target = target.replace("XX", "BB");
        if (target.contains("X")) {
            bw.write("-1" + "\n");
        } else {
            bw.write(target + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}