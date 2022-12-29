package com.til.algorithm.baekjoon.bigstone.week_1;

import java.io.*;

public class BOJ_11655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String target = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (char c : target.toCharArray()) {
            if (Character.isDigit(c) || Character.isSpaceChar(c)) {
                sb.append(c);
                continue;
            }
            if (Character.isUpperCase(c)) {
                if (c + 13 - 'A' < 26) {
                    sb.append((char) (c + 13));
                    continue;
                }
                sb.append((char) (c - 13));
                continue;
            }
            if (c + 13 - 'a' < 26) {
                sb.append((char) (c + 13));
                continue;
            }
            sb.append((char) (c - 13));
        }
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}