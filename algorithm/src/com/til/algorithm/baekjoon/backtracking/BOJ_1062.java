package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1062 {

    private static int N;
    private static int K;
    private static int answer;
    private static String[] words;
    private static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];

        if (K < 5) {
            bw.write("0" + "\n");
        } else {
            alphabet['a' - 'a'] = 1;
            alphabet['n' - 'a'] = 1;
            alphabet['t' - 'a'] = 1;
            alphabet['i' - 'a'] = 1;
            alphabet['c' - 'a'] = 1;

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

    private static void backtracking(int depth, int index) {
        if (depth == K - 5) {
            answer = Math.max(answer, getReadableWordCount());
            return;
        }
        for (int i = index; i < alphabet.length; i++) {
            if (alphabet[i] != 1) {
                alphabet[i] = 1;
                backtracking(depth + 1, i + 1);
                alphabet[i] = 0;
            }
        }
    }

    private static int getReadableWordCount() {
        int count = 0;
        for (String word : words) {
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (alphabet[c - 'a'] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}