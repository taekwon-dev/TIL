package com.til.algorithm.baekjoon.string;

import java.io.*;

public class BOJ_1316 {

    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (isGroupWord(br.readLine())) {
                answer++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isGroupWord(String word) {
        used = new boolean[26];
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                if (used[word.charAt(j) - 'a']) {
                    return false;
                }
                if (word.charAt(i) != word.charAt(j)) {
                     used[word.charAt(i) - 'a'] = true;
                     i = j;
                }
            }
        }
        return true;
    }
}