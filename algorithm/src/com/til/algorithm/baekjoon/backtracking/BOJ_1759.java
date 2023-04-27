package com.til.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {

    private static int N;
    private static int M;
    private static char[] alphabet;
    private static char[] password;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        password = new char[N];
        alphabet = new char[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabet);
        backtracking(0, 0);

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth, int start) {
        if (depth == N) {
            if (isValid()) {
                answer.append(password).append("\n");
            }
            return;
        }
        for (int i = start; i < M; i++) {
            password[depth] = alphabet[i];
            backtracking(depth + 1, i + 1);
        }
    }

    private static boolean isValid() {
        int vowel = 0;
        int consonant = 0;
        for (char c : password) {
            if (isVowel(c)) {
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

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}