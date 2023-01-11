package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_1152 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] words = br.readLine().split(" ");
        int answer = 0;
        for (String word : words) {
            if (word.length() > 0) {
                answer++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}