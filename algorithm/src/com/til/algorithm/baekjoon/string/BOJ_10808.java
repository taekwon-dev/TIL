package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_10808 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        int[] alphabet = new int[26];
        for (char c : S.toCharArray()) {
            alphabet[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int count : alphabet) {
            sb.append(count).append(" ");
        }

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}