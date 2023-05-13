package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1062 {

    private static int N;
    private static int K;
    private static String[] words;
    private static boolean[] alphabet;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        alphabet = new boolean[26];

        if (K < 5) {
            bw.write(0 + "\n");
        } else {
            alphabet['a' - 'a'] = true;
            alphabet['n' - 'a'] = true;
            alphabet['t' - 'a'] = true;
            alphabet['i' - 'a'] = true;
            alphabet['c' - 'a'] = true;

            words = new String[N];
            for (int i = 0; i < N; i++) {
                words[i] = br.readLine();
            }
            backtracking(0, 0);

            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int start) {
        if (depth == K - 5) {
            answer = Math.max(answer, getReadableSize());
            return;
        }
        for (int i = start; i < alphabet.length; i++) {
            if (!alphabet[i]) {
                alphabet[i] = true;
                backtracking(depth + 1, i + 1);
                alphabet[i] = false;
            }
        }
    }

    private static int getReadableSize() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            char[] word = words[i].toCharArray();
            boolean readable = true;
            for (char c : word) {
                if (alphabet[c - 'a']) {
                    continue;
                }
                readable = false;
                break;
            }
            if (readable) {
                count++;
            }
        }
        return count;
    }
}