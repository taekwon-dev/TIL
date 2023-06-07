package com.til.algorithm.baekjoon.sort;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class BOJ_1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        String[] words = set.toArray(new String[0]);
        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for (String word : words) {
            bw.write(word + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}