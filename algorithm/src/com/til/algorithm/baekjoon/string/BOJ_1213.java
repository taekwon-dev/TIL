package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alphabet = new int[26];
        for (char c : br.readLine().toCharArray()) {
            alphabet[c - 'A']++;
        }

        int oddCnt = 0;
        for (int cnt : alphabet) {
            if (cnt % 2 != 0) {
                oddCnt++;
            }
        }

        StringBuilder answer = new StringBuilder();

        if (oddCnt > 1) {
            answer.append("I'm Sorry Hansoo");
        } else {
            StringBuilder front = new StringBuilder();
            for (int i = 0; i < alphabet.length; i++) {
                for (int j = 0; j < alphabet[i] / 2; j++) {
                    front.append((char) (i + 'A'));
                }
            }
            answer.append(front);
            String end = front.reverse().toString();

            StringBuilder mid = new StringBuilder();
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] % 2 == 1) {
                    mid.append((char) (i + 'A'));
                }
            }
            answer.append(mid).append(end);
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}