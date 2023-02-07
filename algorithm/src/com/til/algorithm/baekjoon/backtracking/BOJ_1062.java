package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1062 {

    private static int N;
    private static int K;
    private static boolean[] alphabet = new boolean[26];
    private static String[] words;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        if (K < 5) {
            bw.write("0" + "\n");
        } else {
            alphabet['a' - 'a'] = true;
            alphabet['t' - 'a'] = true;
            alphabet['n' - 'a'] = true;
            alphabet['i' - 'a'] = true;
            alphabet['c' - 'a'] = true;

            backtracking(0, 0);

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int index) {
        if (depth == K - 5) {
            answer = Math.max(answer, getReadableNumber());
            return;
        }
        for (int i = index; i < alphabet.length; i++) {
            if (!alphabet[i]) {
                alphabet[i] = true;
                backtracking(depth + 1, i + 1);
                alphabet[i] = false;
            }
        }
    }

    private static int getReadableNumber() {
        int num = 0;
        for (String word : words) {
            if (isReadable(word)) {
                num++;
            }
        }
        return num;
    }

    private static boolean isReadable(String word) {
        for (char c : word.toCharArray()) {
            if (!alphabet[c - 'a']) {
                return false;
            }
        }
        return true;
    }
}