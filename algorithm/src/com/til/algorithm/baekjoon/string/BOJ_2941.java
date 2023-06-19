package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_2941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        String[] letters = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String letter : letters) {
            if (word.contains(letter)) {
                word = word.replace(letter, "?");
            }
        }

        bw.write(word.length() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}