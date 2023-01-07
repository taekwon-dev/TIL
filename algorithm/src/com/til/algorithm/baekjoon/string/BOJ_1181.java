package com.til.algorithm.baekjoon.string;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        Collections.sort(words, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        String prev = null;
        for (String word : words) {
            if (word.equals(prev)) {
                continue;
            }
            prev = word;
            bw.write(word + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}