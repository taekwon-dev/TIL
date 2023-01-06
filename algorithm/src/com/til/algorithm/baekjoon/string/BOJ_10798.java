package com.til.algorithm.baekjoon.string;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_10798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> words = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            words.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < words.size(); j++) {
                if (i > words.get(j).length() - 1) {
                    continue;
                }
                sb.append(words.get(j).charAt(i));
            }
        }

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}