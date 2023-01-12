package com.til.algorithm.baekjoon.string;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_1032 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Boolean> patternChecker = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        String prev = null;
        while (N-- > 0) {
            String filename = br.readLine();
            for (int i = 0; i < filename.length(); i++) {
                if (!patternChecker.containsKey(i)) {
                    patternChecker.put(i, true);
                }
                if (prev != null && prev.charAt(i) != filename.charAt(i)) {
                    patternChecker.put(i, false);
                }
            }
            prev = filename;
        }

        List<Integer> indices = new ArrayList<>(patternChecker.keySet());
        StringBuilder answer = new StringBuilder();
        for (int index : indices) {
            if (patternChecker.get(index)) {
                answer.append(prev.charAt(index));
                continue;
            }
            answer.append('?');
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}