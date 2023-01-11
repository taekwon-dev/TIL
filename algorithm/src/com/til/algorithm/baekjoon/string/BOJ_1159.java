package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_1159 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] alphabet = new int[26];
        while (N-- > 0) {
            alphabet[br.readLine().charAt(0) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] >= 5) {
                sb.append((char) (i + 'a'));
            }
        }
        if (sb.length() == 0) {
            bw.write("PREDAJA" + "\n");
        } else {
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}