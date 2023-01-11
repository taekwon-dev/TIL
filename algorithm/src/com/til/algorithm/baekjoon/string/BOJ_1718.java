package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_1718 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String plain = br.readLine();
        String key = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plain.length(); i++) {
            char p = plain.charAt(i);
            if (Character.isSpaceChar(p)) {
                sb.append(" ");
                continue;
            }
            int gap = key.charAt(i % key.length()) - 'a' + 1;
            if (p - gap < 'a') {
                sb.append((char) (p - gap + 26));
                continue;
            }
            sb.append((char) (p - gap));
        }

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}