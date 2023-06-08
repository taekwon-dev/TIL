package com.til.algorithm.baekjoon.sort;

import java.io.*;
import java.util.Arrays;

public class BOJ_11656 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        String[] suffix = new String[word.length()];

        for (int i = 0; i < suffix.length; i++) {
            suffix[i] = word.substring(i);
        }

        Arrays.sort(suffix);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < suffix.length; i++) {
            answer.append(suffix[i]).append("\n");
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}