package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_11365 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = null;
        StringBuilder sb = null;
        while (!(input = br.readLine()).equals("END")) {
            sb = new StringBuilder(input);
            bw.write(sb.reverse().toString() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}