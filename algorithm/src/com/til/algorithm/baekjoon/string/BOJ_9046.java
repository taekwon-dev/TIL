package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_9046 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] alphabet;
        for (int t = 0; t < T; t++) {
            alphabet = new int[26];
            String encoded = br.readLine();
            for (char c : encoded.toCharArray()) {
                if (Character.isSpaceChar(c)) {
                    continue;
                }
                alphabet[c - 'a']++;
            }
            int max = 0;
            for (int i = 0; i < alphabet.length; i++) {
                max = Math.max(max, alphabet[i]);
            }
            int maxIndex = 0;
            int maxCount = 0;
            for (int i = 0; i < alphabet.length; i++) {
                if (max == alphabet[i]) {
                    maxIndex = i;
                    maxCount++;
                }
            }
            if (maxCount > 1) {
                bw.write("?" + "\n");
            } else {
                bw.write((char) (maxIndex + 'a') + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}