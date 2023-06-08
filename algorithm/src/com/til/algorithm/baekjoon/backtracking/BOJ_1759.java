package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {

    private static int L;
    private static int C;
    private static char[] passwd;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        passwd = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            passwd[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(passwd);

        backtracking(0, 0, "");

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int start, String candidate) {
        if (depth == L) {
            if (isValid(candidate)) {
                answer.append(candidate).append("\n");
            }
            return;
        }
        for (int i = start; i < C; i++) {
            backtracking(depth + 1, i + 1, candidate + passwd[i]);
        }
    }

    private static boolean isValid(String candidate) {
        int vowel = 0;
        int consonant = 0;
        for (char c : candidate.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }
        if (vowel >= 1 && consonant >= 2) {
            return true;
        }
        return false;
    }
}