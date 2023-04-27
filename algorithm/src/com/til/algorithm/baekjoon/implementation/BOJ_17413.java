package com.til.algorithm.baekjoon.implementation;

import java.io.*;

public class BOJ_17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean open = false;
        StringBuilder plain = new StringBuilder();
        StringBuilder reverse = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        String S = br.readLine();
        for (char c : S.toCharArray()) {
            if (c == '<') {
                open = true;
                if (reverse.length() > 0) {
                    answer.append(reverse.reverse());
                    reverse = new StringBuilder();
                }
            }
            if (open) {
                plain.append(c);
            } else {
                if (Character.isSpaceChar(c)) {
                    answer.append(reverse.reverse()).append(" ");
                    reverse = new StringBuilder();
                } else {
                    reverse.append(c);
                }
            }
            if (c == '>') {
                open = false;
                answer.append(plain);
                plain = new StringBuilder();
            }
        }
        if (reverse.length() > 0) {
            answer.append(reverse.reverse());
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}