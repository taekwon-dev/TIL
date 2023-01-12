package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_11655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();

        StringBuilder answer = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                answer.append(c);
                continue;
            }
            if (!Character.isAlphabetic(c)) {
                answer.append(c);
                continue;
            }
            answer.append(ROT13(c));
        }
        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static char ROT13(char target) {
        if (Character.isUpperCase(target)) {
            if (target + 13 > 'Z') {
                return (char) (target + 13 - 26);
            }
        }
        if (target + 13 > 'z') {
            return (char) (target + 13 - 26);
        }
        return (char) (target + 13);
    }
}