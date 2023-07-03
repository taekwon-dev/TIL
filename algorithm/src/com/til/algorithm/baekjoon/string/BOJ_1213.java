package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int[] alphabet = new int[26];
        for (char c : input.toCharArray()) {
            alphabet[c - 'A']++;
        }

        int odd = 0;
        char oddChar = 'A';
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] % 2 != 0) {
                odd++;
                oddChar = (char) (i + 'A');
            }
        }
        if (odd > 1) {
            bw.write("I'm Sorry Hansoo" + "\n");
        } else {
            StringBuilder answer = new StringBuilder();
            StringBuilder front = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alphabet[i] / 2; j++) {
                    front.append((char) (i + 'A'));
                }
            }
            answer.append(front);
            String end = front.reverse().toString();

            if (input.length() % 2 != 0) {
                answer.append(oddChar).append(end);
            } else {
                answer.append(end);
            }

            bw.write(answer.toString() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}